/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shenonodecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShenonoDecode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int keliamasis = 0;
        File nustatymai = new File("nustatymai.txt");
        BufferedReader br = new BufferedReader(new FileReader(nustatymai));
        String st;
        int counteris = 0;
        ArrayList<Taisykles> visos = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (st.length() == 1) {
                keliamasis = Integer.parseInt(st);
            } else {
                char charerk[] = st.toCharArray();
                String taisykle = "";
                for (int i = 2; i < charerk.length; i++) {
                    taisykle += charerk[i];
                }
                visos.add(new Taisykles(charerk[0], taisykle));

                System.out.println(visos.get(counteris).raide + " koduote: " + visos.get(counteris).taisykle);
                counteris++;
            }
        };
        byte[] array = Files.readAllBytes(Paths.get("atsakymas.txt"));
        String laikinasis = "";
        String koduote = "";

 
            for (int i = 0; i < array.length-1; i++) {
                //System.out.println(String.format("%8s",Integer.toBinaryString(uzkoduota_zinute.get(0) & 0xFF)).replace(" ", "0"));
                koduote += String.format("%8s", Integer.toBinaryString(array[i] & 0xFF)).replace(" ", "0");
               
            }
            laikinasis= String.format("%8s", Integer.toBinaryString(array[array.length-1] & 0xFF)).replace(" ", "0");
            for(int i = 0 ; i < keliamasis; i ++)
            {
              koduote+=laikinasis.charAt(i);
                
            }
        

        System.out.println(koduote);
        String Sutapimas = "";
        String Atkoduota_zinute = "";
        for (int i = 0; i < koduote.length(); i++) {

            Sutapimas += koduote.charAt(i);
            // System.out.println(Sutapimas);

            for (int j = 0; j < visos.size(); j++) {
                if (Sutapimas.equals(visos.get(j).taisykle)) {

                    Atkoduota_zinute += visos.get(j).raide;
                    Sutapimas = "";
                }
            }
        }
        System.out.println(Atkoduota_zinute);
               String Nustatymai = "";
   FileWriter writer = new FileWriter("atkoduota.txt");
    PrintWriter printWriter = new PrintWriter(writer);
           printWriter.println(Atkoduota_zinute);
       writer.close();
    }

}
