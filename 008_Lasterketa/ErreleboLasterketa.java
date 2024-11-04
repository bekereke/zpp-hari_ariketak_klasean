package unieibar;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ErreleboLasterketa{

    static Semaphore semaforoa = new Semaphore(0,true);  //mutex

    static class Korrikalaria extends Thread{
        private int id;

        public Korrikalaria(int id){
            this.id = id;
        }

        public int hurrengoa(){
            return (id+1);
        }

        @Override
        public void run(){
            try {
                semaforoa.acquire();
                System.out.println("I'm thread " + id + ", running...");
                Thread.sleep(new Random().nextInt(3000)+1000);  // pare bat segundu -+-
            } catch (Exception e) {
                e.printStackTrace();
            } 
            if ((id+1)<=4){
                System.out.println("I'm done. Passing the baton to child " + (id+1) +"."); 
            } else {
                System.out.println("I'm done!");
            }
            semaforoa.release();
        }
    }

    public static void main(String[] args) {
        Korrikalaria[] korrikalariak = new Korrikalaria[4];
        
        for(int i = 0; i<korrikalariak.length; i++){
            korrikalariak[i] = new Korrikalaria(i+1);
            korrikalariak[i].start();
            try {
                Thread.sleep(200); // tranpatxoa: semaforora ordenan iristeko astia dutela bermatzeko!
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("All threads created.");
        try {
            Thread.sleep(1000);
            System.out.println("Ready, set, go!");
            semaforoa.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Korrikalaria korrikalaria : korrikalariak){
            try {    
                korrikalaria.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("All threads have finished.");
    }

}