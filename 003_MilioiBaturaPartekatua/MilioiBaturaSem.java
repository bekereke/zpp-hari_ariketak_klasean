package unieibar;

import java.util.concurrent.Semaphore;

public class MilioiBaturaSem {
    
    //private static long guztira = 0L;  
    private static Emaitza emaitza = new Emaitza();  //BALIABIDE PARTEKATUA: LASTERKETA BALDINTZA! 
    private static Semaphore semaforoa = new Semaphore(1);  //MUTEX

    public static void main(String[] args) {

        Thread[] hariak = new Thread[4];
        int banaketaBakoitzari = 1000000 / hariak.length;
        long start = System.currentTimeMillis();

        for (int i = 0; i < hariak.length; i++) {
            int nondik = i * banaketaBakoitzari; //0 (0haria)
            int nora = (i + 1) * banaketaBakoitzari - 1; //254.999 (0haria)
            hariak[i] = new Thread(new BaturaHaria(i, nondik, nora, emaitza));
            System.out.println(i + "hariak " + nondik + "(e)tik " + nora + "(e)raino.");
            hariak[i].start();
        }

        for (Thread haria : hariak) {
            try {
                haria.join();  //itxaron batura guztiei!
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Milioi batura: " + emaitza.get());
        System.out.println("Time-elapsed in mm: "+(end-start));
    }

    private static long lortuPartzialak(int hasi, int buka) {
        long bat = 0L;
        for (int i = hasi; i <= buka; i++) {
            bat += (long)i;
        }
        return bat;
    }

    static class BaturaHaria implements Runnable {
        private final int hasi;
        private final int buka;
        private String izena;
        private Emaitza emaitza;

        public BaturaHaria(int i, int hasi, int buka, Emaitza emaitza) {
            this.izena = Integer.toString(i);
            this.hasi = hasi;
            this.buka = buka;
            this.emaitza = emaitza;
        }

        @Override
        public void run() {
            long partziala = lortuPartzialak(hasi,buka);   
            System.out.println(izena + "hariak: " + partziala);
            emaitza.set(partziala);
        }
    }

    static class Emaitza{
        private long emaitza;

        public Emaitza(){
            emaitza = 0L;
        }

        public long set(long partziala){
            try {
                semaforoa.acquire();
                emaitza += partziala;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                semaforoa.release();
            }
            return emaitza;
        }

        public long get(){
            return emaitza;
        }
    }
}
