
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/*
 * Main.java
 * @author R.Vaicekauskas
 * Pirmosios užduoties sprendimo java šablonas
 */

// Irašyti reikiamą paketo vardą
//package pirmoji;

/**
 * Dirbant NetBeans aplinkoje klasė "Main" sugeneruojama automatiškai
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Programa pradeda darba");
       TestThread.pradeti();       
       System.out.println("Programa baigia darba.");
    }
}

/*
   Naujai sukurta klase.
   Gijos klasė, turi būti išvesta iš Thread
*/
class TestThread extends Thread
{
   // Gijos objekto specifiniai duomenys
   Eile bendras;
   
   // Konstruktorius, skirtas perduoti duomenis gijos objektui
   public TestThread(Eile bendras) 
   {
      this.bendras = bendras;
   }

   // Metodas, vykdomas paleidus giją
   // Thread.run()
   public void run()
   {
      System.out.println("Gija " + this + " paleista");
      randomGeneratorius gautiReiksmem = new randomGeneratorius();
      String n = new String();
      
      for (int i = 0; i < 1000; i++)
      {
	     // Sinchronizuoto bloko pradžia
		 // Bloko viduje galima saugiai skaityti/modifikuoti 
		 // Objekto bendras laukus
		 // *** Užkomentavus turėtų atsirasti duomenų atnaujinimo konfliktai ***
         n = gautiReiksmem.getName();
         //System.out.println(n.duomenys);
        synchronized(bendras) 
       {
	 	     // Kontrolinis spausdinimas, kad įsitikinti vienalaikiu gijų veikimu 
		    // System.out.println("Gija " + this + " pries atnaujinant bendra kintamaji");
			 
			 // Kviečiame metodą, kuris modifikuoja objekto lauko reikšmę
			 // *** Konkrečiam taikymui metodo kvietinys/iai turi būti pakeistas/i***
                       
                         
            bendras.pridetiIEile(n);

	 	     // Kontrolinis spausdinimas, kad įsitikinti vienalaikiu gijų veikimu 
		    // System.out.println("Gija " + this + " atnaujino bendra kintamaji");
       }
      }
    //  System.out.println("Gija " + this + " baigia darbą");
   }
   
   // Metodas paleidžiantis gijas darbui ir išvedantis rezultatą
   public static void pradeti()
   {
         // Sukuriame objektą, kurį bendrai naudos kelios gijos 	
         Eile bendras = new Eile();
        
		 
         try
         { 
		       // Sukuriame ir startuojame pirmąją giją
			   // perduodami kaip parametrą objektą "bendras"
               Thread t1 = new TestThread(bendras); 
               t1.start();
			   
		       // Sukuriame ir startuojame pirmąją giją
              Thread t2 = new TestThread(bendras);
               t2.start();
                Thread t3 = new TestThread(bendras);
               t3.start();

			   // Laukiame, kol abi gijos baigs darbą 
               t1.join(); t2.join();t3.join();
			   
			   // Išvedame galutinį rezultatą
                           bendras.israsytiRegistruotus();
         } 
         catch (InterruptedException exc)
         {
            System.out.println("Ivyko klaida "+exc);
         }
   }
}

/*
Klasė, aprašanti bendrai gijų naudojamą objektą
*** Konkrečiam taikymui turi būti pakeistas***
*/
class Eile
{
    // Laukas, kurį skaitys modifikuos kelios gijos
    public ArrayList<String> Eile= new ArrayList<>();
	
	// Metodas modifikuojantis objekto turinį
	public void pridetiIEile(String n) 
        {
             
          
            Eile.add(n);
           //System.out.println(Eile.get(Eile.size()-1).duomenys + "  Eileje "+ Eile.get(Eile.size()-1).kelintasEileje);
        }
        public void Sumazinti()
        {
            Eile.remove(0);
        }
        public void israsytiRegistruotus()
        {
            Iterator it = Eile.iterator();
            while(it.hasNext())
            {
                System.out.println(it.next());
                
            }
            System.out.println(Eile.size());
        }
}
class ZmogausDuomenys
{
    public String duomenys;
    public int kelintasEileje;
    
}
class randomGeneratorius
{
    String vardai[][]={{"Tomas","Aurimas","Justas","Ignas","Darius","Gabrielius","Karolis","Robertas","Edvardas","Simas","Rysiek","Miroslav","Kipras","Mantas","Otas","Matas","Deividas",
    "Arnas","Jokubas","Edgaras","Deividas"},{"Viktorija","Katia","Agne","Ingrida","Sandra","Gabriele","Fausta","Greta","Ruta","Aukse","Elinga","Raminta","Rimgaile","Violeta"}}; 
    //20 vaikinu ir 14 merginu
    String pavardes[][] = {{"Zapolskas","Lapinskas","Sendrauskas","Sakutis","Giedraitis","Mazuolis","Vigaudas","Paulikas","Adamonis","Cibulskas","Rastauskas","volodko"},
        {"Mikalauskyte","Ned","Lej","Nasoliene","Moroziene","Krovinckaite","Peris","Urblionyte","Lucinskaja"}};
    //12 vaikinu pavardziu ir 9 merginu
    public String getName()
    {
        
        Random rand = new Random();
        int Lytis = rand.nextInt(2);
        if(Lytis ==1)
        {
        return vardai[Lytis][rand.nextInt(14)] +" " + pavardes[Lytis][rand.nextInt(9)]+" " + Integer.toString(rand.nextInt(4000000));
        }
        else
        {
        return vardai[Lytis][rand.nextInt(20)] +" " + pavardes[Lytis][rand.nextInt(12)]+" " + Integer.toString(rand.nextInt(4000000));
        }
    }
}