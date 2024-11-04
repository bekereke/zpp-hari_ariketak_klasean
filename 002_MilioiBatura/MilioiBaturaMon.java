package unieibar;

public class MilioiBaturaMon {

    private static long guztira = 0L;  // int mota jarriz gero overflow!

    public static void main(String[] args) {

        Thread[] hariak = new Thread[4];
        int banaketaBakoitzari = 1000000 / hariak.length;
        long start = System.currentTimeMillis();

        for (int i = 0; i < hariak.length; i++) {
            int nondik = i * banaketaBakoitzari; //0 (0haria)
            int nora = (i + 1) * banaketaBakoitzari - 1; //254.999 (0haria)
            hariak[i] = new Thread(new BaturaHaria(i, nondik, nora));
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
        System.out.println("Milioi batura: " + guztira);
        System.out.println("Time-elapsed in mm: "+(end-start));
    }

    private static long lortuPartzialak(int hasi, int buka) {
        long bat = 0L;
        for (int i = hasi; i <= buka; i++) {
            bat += (float)i;
        }
        return bat;
    }

    private static synchronized void batuPartzialak(long part) {
        guztira += part;
    }

    static class BaturaHaria implements Runnable {
        private final int hasi;
        private final int buka;
        private String izena;

        public BaturaHaria(int i, int hasi, int buka) {
            this.izena = Integer.toString(i);
            this.hasi = hasi;
            this.buka = buka;
        }

        @Override
        public void run() {
            long partziala = lortuPartzialak(hasi,buka);   
            System.out.println(izena + "hariak: " + partziala);
            batuPartzialak(partziala);  //(batzuetan, float jarriz gero) Milioi batura: 5.00000227E11 eta beste batzuetan Milioi batura: 5.0000026E11
        }
    }
}