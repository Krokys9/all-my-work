/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shennon;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class visosRaides {
     public ArrayList<raidesSuTikimybem> visos= new ArrayList<raidesSuTikimybem>();
    ArrayList<Byte> uzkoduota= new ArrayList<Byte>();
    int symboliuSkaicius;
    int isvisoSimboliuSkaicius;
    int virsausIsviso;
    int apaciosIsviso;
    public visosRaides(char simboliai[], int dazniai[], int symboliuSkaicius, int isvisoSimboliuSkaicius)
            
    {
        this.symboliuSkaicius = symboliuSkaicius;
        this.isvisoSimboliuSkaicius = isvisoSimboliuSkaicius;
        int n = 0;
        int temp = -1;
        char tempc = 'c';
        for (int i = 0 ; i < symboliuSkaicius ; i++)
        {
            temp = dazniai[i];
            for(int j = 0 ; j < symboliuSkaicius; j++)
            {
                if(dazniai[i] > dazniai[j])
                {
                    temp = dazniai[i];
                    dazniai[i] = dazniai[j];
                    dazniai[j] = temp;
                    tempc = simboliai[i];
                    simboliai[i] = simboliai[j];
                    simboliai[j] = tempc;
                }
            }
        }
        for(int i =0 ; i < symboliuSkaicius; i++)
        {
        visos.add(new raidesSuTikimybem(simboliai[i],dazniai[i]));
        }
        
    }
     public visosRaides(ArrayList<raidesSuTikimybem> lul, int isvisoRaidziu)
     {
         this.symboliuSkaicius = lul.size();
         this.isvisoSimboliuSkaicius =isvisoRaidziu;
         this.visos = lul;
         
     }
            
    
    public void PrintAllRaides()
    {
         for(int i =0 ; i < symboliuSkaicius; i++)
        {
        System.out.println(visos.get(i).raide + " jos tikimybe : " + visos.get(i).tikimybe+ "  kodavimas: "+ visos.get(i).kodavimas);
        }
    }
    public void darykAtsakyma()
    {
    ArrayList<raidesSuTikimybem> virsus= new ArrayList<raidesSuTikimybem>();
    ArrayList<raidesSuTikimybem> apacia= new ArrayList<raidesSuTikimybem>();
        int ApaciosRezis = 0;
        int kur_sustojo = 0;
      if (visos.size()!=1)
      {
        for(int i = symboliuSkaicius-1; i >= 0; i --)
        {
            
            
            if((ApaciosRezis >= (isvisoSimboliuSkaicius-ApaciosRezis)) || i == 0)
            {
               
                kur_sustojo = i+1;
                for(int j =i ; j >= 0;j--)
                {
                visos.get(j).kodavimas +="0";
                virsus.add(0, (new raidesSuTikimybem(visos.get(i).raide, visos.get(i).tikimybe,visos.get(i).kodavimas)));
                }
                // virsutinis rezis kodavimas += 0
                // apatinis rezis kodavimas += 1
                break;
            }
            else 
            {
                 ApaciosRezis += visos.get(i).tikimybe;
                visos.get(i).kodavimas +="1";
                apacia.add(0, (new raidesSuTikimybem(visos.get(i).raide, visos.get(i).tikimybe,visos.get(i).kodavimas)));
            }
        } 
       // System.out.println(kur_sustojo);
        darykatsakymaDarKarta(virsus,0,isvisoSimboliuSkaicius-ApaciosRezis, 0);
        darykatsakymaDarKarta(apacia,kur_sustojo,ApaciosRezis,0);
         
      }
    
    
    }
    private void darykatsakymaDarKarta(ArrayList<raidesSuTikimybem> visosa, int Apaciosintas, int visosimboliu, int down)
    {
    ArrayList<raidesSuTikimybem> virsus= new ArrayList<raidesSuTikimybem>();
    ArrayList<raidesSuTikimybem> apacia= new ArrayList<raidesSuTikimybem>();
        int ApaciosRezis = 0;
        int kur_sustojo = 0;
        
      if (visosa.size()!=1)
      {
        for(int i = visosa.size()-1; i >= 0; i --)
        {   
        //    System.out.println(visosa.get(i).raide+ " indeksas: " + i );
            
            if((ApaciosRezis >= (visosimboliu-ApaciosRezis)) || i == 0)
            {
                
                kur_sustojo = i+1;
                for(int j =i ; j >= 0;j--)
                {
                visos.get(j+Apaciosintas+down).kodavimas +="0";
                virsus.add(0, (new raidesSuTikimybem(visosa.get(i).raide, visosa.get(i).tikimybe,visosa.get(i).kodavimas)));
                }
                // virsutinis rezis kodavimas += 0
                // apatinis rezis kodavimas += 1
                break;
            }
            else 
            {
                ApaciosRezis += visosa.get(i).tikimybe;
                visos.get(i+Apaciosintas+down).kodavimas +="1";
                apacia.add(0, (new raidesSuTikimybem(visosa.get(i).raide, visosa.get(i).tikimybe,visosa.get(i).kodavimas)));
            }
        } 
       
     darykatsakymaDarKarta(virsus,Apaciosintas,visosimboliu-ApaciosRezis,0);
     darykatsakymaDarKarta(apacia,Apaciosintas+kur_sustojo,ApaciosRezis, down);
  
      }
      else
      {
          
      }
    }
   public void nustatymai(int keliamasis) throws FileNotFoundException, IOException
   {
       String Nustatymai = "";
   FileWriter writer = new FileWriter("nustatymai.txt");
    PrintWriter printWriter = new PrintWriter(writer);
           for (int i = 0 ; i < visos.size();i++)
           {
              Nustatymai = "";
              Nustatymai += (visos.get(i).raide);
              Nustatymai += " ";
              Nustatymai += (visos.get(i).kodavimas);
              
              printWriter.println(Nustatymai);
           }
       printWriter.println(keliamasis);
       writer.close();
   }
}

