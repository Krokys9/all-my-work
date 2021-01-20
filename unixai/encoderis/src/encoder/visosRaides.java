/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author User
 */
public class visosRaides {

    public ArrayList<raidesSuTikimybem> visos = new ArrayList<raidesSuTikimybem>();
    int k = 2;
    int isvisoRaidziu = 0;
    double tempase = 0.0;

    public visosRaides(int k) {
        this.k = k;
    }

    public void prideti(String zodis) {
        boolean pasikartoja = false;
        isvisoRaidziu++;
        if (visos.size() == 0) { // jei nieko viduje nera prideda
            visos.add(new raidesSuTikimybem(zodis, 1));
            pasikartoja = true;
        } else { // kitu atveju eina per algoritma kuris tikrina ar yra, jei nera prideda nauja, jei yra padidina tik dazni. 
/// sito sudetingumas eksponentinis todel reiktu kazka geriau sugalvoti 
            for (int i = 0; i < visos.size(); i++) {
                if (visos.get(i).raide.equals(zodis)) {
                    pasikartoja = true;
                    visos.get(i).addChance(); // padina tos raides tikimybe
                    break; // prisideda prie to elemento daznis

                }

            }
            if (!pasikartoja) {
                visos.add(new raidesSuTikimybem(zodis, 1));
            }
        }

    }

    public void Printout() // isveda pasitikrinimui 
    {
        for (int i = 0; i < visos.size(); i++) {
            visos.get(i).print();
        }
        System.out.println("isVisoRaidziu: " + isvisoRaidziu);

    }

    public void PrintoutIdkWhy() { // nezinau kam riekalingas , kazka ne taip supratau parasiau sita 
        String temp;
        String temp2 = "";
        for (int i = 0; i < visos.size(); i++) {
            temp = visos.get(i).raide;
            for (int j = 0; j < k; j++) {
                temp2 += temp.charAt(0);
                temp = temp.substring(1);
                if (temp2.length() == 8) {

                    // System.out.println((char) Integer.parseInt(visos.get(i).raide, 2) + "  koduote:" + visos.get(i).kodavimas + " daznis:" + visos.get(i).tikimybe);
                    System.out.println((char) Integer.parseInt(temp2, 2));

                    temp2 = "";
                }
                // System.out.println(temp2.length());

            }

        }
        //System.out.println(visos.size());
    }

    private void priskiriam_realias_reiksmes() {
        for (int i = 0; i < visos.size(); i++) {
            visos.get(i).setchanceForShennon(isvisoRaidziu);
        }
    }

    private void priskiriam_logoritmo_virsu() {
        for (int i = 0; i < visos.size(); i++) {
           // System.out.println((int) Math.ceil((Math.log(1 / visos.get(i).tikimybePoKablelio)) / Math.log(2)));
            visos.get(i).setLogoritmo_aukstis((int) Math.ceil((Math.log(1 / visos.get(i).tikimybePoKablelio)) / Math.log(2)));
        }
    }

    private void priskirti_kodus() {
        
        for (int i = 0; i < visos.size(); i++) {

            visos.get(i).prisiskirtiKoda(tempase);
            tempase += visos.get(i).tikimybePoKablelio;
            
        }
    }

    public void priskirti_kodavimus() {
        this.Sort(); // surusiuojam viska ir tada skaiciuojam per For'a visiem atskirai ju per kableli tikimybes
        this.priskiriam_realias_reiksmes(); // priskiriam double reiksmes 
        this.priskiriam_logoritmo_virsu(); // gauname virsu 
        // lieka tiktai priskirti kodus.
        this.priskirti_kodus(); // prisiskyre kodavimus , viskas cia nebereikia Viskas atlikta .
        // dabar suskaiciuojam kiekvienam ju  logoritmu virsutini rezi
        // TODO : reikia suskaiciuoti visiem Logoritmus ir ju virsutini rezi, ir tada dar Praskaiciuoti funkcijas kurios sukurs tam tikra bitu koda.
        // kiekviena raide turetu tureti savo logoritma ir t.t. taciau ar apsimoketu atskirai priskirineti, jom savo kodus, visgi dar reikia isrikiuoti pagal tikimybes. 
    }

    public void Sort() // isrikiuoijam mazejimo tvarka Didz > maziausias 
    {

        for (int i = 0; i < visos.size(); i++) {
            for (int j = 0; j < visos.size(); j++) {
                if (visos.get(i).tikimybe > visos.get(j).tikimybe) {
                    Collections.swap(visos, j, i);

                }

            }
        }
    }

    public String GrazintiKoduote(String a) {
        
          for (int i = 0; i < visos.size(); i++) {
              //System.out.println(i+ " ar sitas: " + a + " yra lygus sitam :" +visos.get(i).raide);
              if(a.equals(visos.get(i).raide))
              {
                  return visos.get(i).kodavimas;
                  
                
              }
          }
          return "";
        // TODO: reikia kad grazintu koduote , pagal zodi kuri gauname pas save 
    }
    public int kiekYrauzkoduotuRaidziu()
    {
        int eikTuTen = 0;
        for(int i = 0 ; i < visos.size();i ++)
        {
            eikTuTen += visos.get(i).kodavimas.length() * visos.get(i).tikimybe;
        }
        //System.out.println(eikTuTen/8);
        return (eikTuTen/8);
        
    }
}
