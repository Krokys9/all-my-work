/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shennon;

import java.io.*;
import java.util.ArrayList;
import java.lang.Object;

/**
 *
 * @author User
 */
public class Shennon {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File nustatymai = new File("koduojamasTekstas.txt");
        int symbols = 0;
        int kartojasiKartu[] = new int[100];
        int isvisoSimboliuSkaicius = 0;
        boolean kartojasi = false;
        String simboliai = "";
        char[] simboliaichar = simboliai.toCharArray();
        BufferedReader br = new BufferedReader(new FileReader(nustatymai));
        String st;
        while ((st = br.readLine()) != null) {
            char charerk[] = st.toCharArray();
            for (int i = 0; i < charerk.length; i++) {
                isvisoSimboliuSkaicius++;
                kartojasi = false;
                if (symbols == 0) {
                    simboliai = simboliai + charerk[i];
                    simboliaichar = simboliai.toCharArray();
                    symbols++;
                }
                for (int j = 0; j < symbols; j++) {
                    if (charerk[i] == simboliaichar[j]) {
                        kartojasi = true;
                        kartojasiKartu[j]++;
                    }
                }
                if (!kartojasi) {
                    simboliai = simboliai + charerk[i];
                    kartojasiKartu[symbols]++;
                    simboliaichar = simboliai.toCharArray();
                    symbols++;
                    kartojasi = true;
                }
            }

        }
        visosRaides ats = new visosRaides(simboliaichar, kartojasiKartu, symbols, isvisoSimboliuSkaicius);
        ats.darykAtsakyma();
        ats.PrintAllRaides();
        String forCodeing = "";
        String Tempa = "";
        File atkoduoti = new File("koduojamasTekstas.txt");
        BufferedReader brAgian = new BufferedReader(new FileReader(atkoduoti));
        while ((st = brAgian.readLine()) != null) {
            char charerk[] = st.toCharArray();
            if (!Tempa.isEmpty()) {

            }
            for (int i = 0; i < charerk.length; i++) {
                for (int j = 0; j < ats.visos.size(); j++) {

                    if (charerk[i] == ats.visos.get(j).raide) {
                        forCodeing += ats.visos.get(j).kodavimas;

                    }

                }
            }
        }
        char uzkodavimas[] = forCodeing.toCharArray();
        String paskutinis_patepimas = "";
        int keliamasis = 0;
        Byte lol  = 0b0000000;//= Byte.parseByte(yikes, 2);
        try (FileOutputStream stream = new FileOutputStream("atsakymas.txt")) {
        for (int i = 0; i < uzkodavimas.length; i += 8) {
            paskutinis_patepimas = "";

            if(uzkodavimas[i] == 1)
            {
                paskutinis_patepimas+="-";
            }
            if(uzkodavimas.length-i >=8)
            {
            for (int j = 0; j < 8; j++) {

                paskutinis_patepimas += uzkodavimas[i+j];

            }
            lol =(byte) (Integer.parseInt(paskutinis_patepimas,2));
            
            System.out.println(lol);
            }
            else
            {
                for (int j = 0; j < uzkodavimas.length-i; j++) {
                    
                   paskutinis_patepimas += uzkodavimas[i+j];
                    
                }
               for (int j =  uzkodavimas.length-i; j < 8; j++) {
                    paskutinis_patepimas += '0';
                    
                    
               }
               keliamasis =   uzkodavimas.length-i;
                lol =(byte) (Integer.parseInt(paskutinis_patepimas,2));
                System.out.println(lol);
                // ka cia daryt neaisku
            }
            
     stream.write(lol);
}
        }
       //System.out.println(String.format("%8s",Integer.toBinaryString(uzkoduota_zinute.get(0) & 0xFF)).replace(" ", "0")); // su situ atgal i binary pasiversiu ez pz
       
       
       //FileUtils.writeByteArrayToFile(new File("pathname"), myByteArray)
      System.out.println(forCodeing);
      ats.nustatymai(keliamasis);

    }

}
