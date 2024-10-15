package unieibar;

import java.util.ArrayList;
import java.util.Random;

public class Gela {
    public static void main(String[] args) {
        ArrayList<Ikaslea> ikasleak = new ArrayList<Ikaslea>();
        String ikasleIzena[]={"Edurne","Asier","Maider","Peru","Josu","Xabier","Mikel","Gerson","Oier","Ander"};
        Ikaslea ikaslea=null;
        Random ausaz = new Random();
        Object monitore = new Object();

        for(int i=0; i<ikasleIzena.length; i++){
            ikaslea = new Ikaslea(ikasleIzena[i]);
            try {
                ikaslea.jarriZenbatAldiz((5+ausaz.nextInt(5)));
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            ikasleak.add(ikaslea);
        }

        System.out.println("Ikasleak ikasgelara iristen HASI dira...");
        for(int j=0; j<ikasleak.size(); j++){
            ikasleak.get(j).start();
        }
        System.out.println("Irakaslea iritsi da...");
        Irakaslea irakaslea = new Irakaslea(monitore);
        irakaslea.jarriIzena("Aitor");
        irakaslea.start();
        
        //hari nagusiak itxaron dezala ikasleei agur batzuk botatzeko astia emateko
/*        try {
            Thread.sleep(7000);
        } catch (Exception e) {
        }
*/
        synchronized (monitore) {
            monitore.notify();  //nahiko balu, synchronized ataletik aurrerago exekuzioarekin jarraitu halako luke: ez da amaitu haria!
        }

        System.out.println("Ikasleak ISILTZEN eta haien lekuetan esertzen...");
        //ikasleak gelditzera behartu (marka erabili)
        for(int k=0; k<ikasleak.size(); k++){
            if (ikasleak.get(k).isAlive()){
                ikasleak.get(k).gelditu();
            }
        }   
        try {
            irakaslea.join();  //orain bai: ziurtatu irakasleak bukatu duela...
        } catch (Exception e) {
        }
        System.out.println("Irakasleak agurtu ditu ikasleak... dena PREST klasea hasteko.");
    }
}
