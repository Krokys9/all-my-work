package encoder;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;



public class encoder extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        launch(args);
        int k = GlobalClass.Key; // kazkokias kintamasis variable. ty. abecele.
        RandomAccessFile aFile = new RandomAccessFile(GlobalClass.filename, "r"); // sukuraim link
        String laikinas = "";
        String Paskutiniai_baitai = "";
        visosRaides ManoRaides = new visosRaides(k);
        String Tikrinimui = ""; //stringas skirtas tikrinti reiksmems skaityme
        FileChannel inChannel = aFile.getChannel(); // atidarom
        ByteBuffer buffer = ByteBuffer.allocate(1024); // buferio dydis 1024
        while (inChannel.read(buffer) > 0) // kol nenureadina 0 baitu readina
        {
            buffer.flip(); // reikioa flippint kad galetumem naudoti
            for (int i = 0; i < buffer.limit(); i++) // kol bufferis nepasiekia limito kazka tai darom 
            {
                // System.out.print((char) buffer.get());
                // ^^^^^^^^^Cia example kaip convertint i stringa   //System.out.println(String.format("%8s",Integer.toBinaryString(uzkoduota_zinute.get(0) & 0xFF)).replace(" ", "0")); // su situ atgal i binary pasiversiu ez pz
                
                Tikrinimui += String.format("%8s", Integer.toBinaryString(buffer.get() & 0xFF)); // gaunam viena baito isdestyma su visais bitais ir israsom.
                Tikrinimui = Tikrinimui.replace(' ', '0'); // pakeiciam visus tarpus 0 kad nebutu  11111,o 00011111
                
                //System.out.println("Tikrinimui pradzia :"+Tikrinimui);

                //TODO : perkeisti i kazka ka galima tikrinti, pvz String  DOne
                while (true) // pokol tinka stringas, sukam toliau viska
                {

                    //Todo: kolkas pakeiciam i k = 2 default 
                    if (Tikrinimui.length() >= k) // jeigu musu laikinasis stringas yra pakankamai didelis kad gautumem zodi
                    {

                        for (int h = 0; h < k; h++) {

                            laikinas += Tikrinimui.charAt(0); // mes imame kodavimo stringus taip kad jie butu mum K ilgio
                            Tikrinimui = Tikrinimui.substring(1); // maziname laikinaji bufferi po viena bita 
                            
                            // tada mes turime israsyti ta zodi i kazka ir tikrinti ar tas zodis jau egzistuoja  UPDATE : Kinda padaryta 
                            // jei egzistuoja, tada mes padidinam dazni ir t.t.  UPDATE : PADARYTA 
                            // cia padryt reikia kazkokia klase kad saugotu viska UPDATE PADARYTA 
                            //Tikrinimui = Tikrinimui.substring(1); Nereikalingas. 
                        }
                        ManoRaides.prideti(laikinas); // kai yra pakanamas ilgis zodzio mes ji addinam prie mano visu raidziu kuriso gali but imanomos 
                         //System.out.println(laikinas);
                        Paskutiniai_baitai = Tikrinimui;
                        
                        laikinas = ""; // ir atnaujinam savo masyva 
                        // reikia prideti i ta savo masyva viska. 

                    } else {
                        break; // tada pabegam jei nebeliko vietos, taciau TODO: kad saugotu paskutinius simbolius jeigu netycia bus  nepilnas baitas // jeigu nelygus man dar reikia pataisyti kad gautumem force gala pridet kazkur 
                    }

                    //TODO: paskaiciuoti kiek yra kokiu simboliu kai K yra kazkoks UPDATE : PADARYTA .
                }
               
            }

            //System.out.println(Paskutiniai_baitai); // paziurim paskiti likusi baita(us)
            buffer.clear(); // do something with the data and clear/compact it.
        }
        // todo: reikia kai baigesi failas sudaryti dazniu lentele. Viskas virsuje buvo skaitymas pirma karta is failo . 
        ManoRaides.priskirti_kodavimus(); // reikia parasyti koda kuris priskirtu visus kodavimus kiekvienai raidei.
        inChannel.position(0); // gristam atgal i failo pradzia
        // cia kursime irasimo faila
        File file = new File("output.txt");
        file.delete();
        RandomAccessFile wFile = new RandomAccessFile("output.txt", "rw"); // sukuraim link
        
        FileChannel outChannel = wFile.getChannel(); // atidarom
        ByteBuffer Irasimas = ByteBuffer.allocate(1024);
        Irasimas.putInt(k);
        Irasimas.putInt(ManoRaides.visos.size());// man dar reikia surasyt visas raides ir koduotes kiekvienam sitam sudui tai lets go
        Irasimas.putInt(Paskutiniai_baitai.length());
        Irasimas.putInt(ManoRaides.kiekYrauzkoduotuRaidziu());
        for (int j = 0; j < Paskutiniai_baitai.length();j++) {
           Irasimas.put((byte)Paskutiniai_baitai.charAt(j));
           //System.out.println((byte)Paskutiniai_baitai.charAt(j)+ " cia yra paskutiniai");
           // reikia patobulinti sita reikala, kad geriau saugotusi informacija apie dekodavima
        } 
        
        
        // reikia nurodyti kiek sito galo dar liko 
        for (int i = 0; i < ManoRaides.visos.size(); i++) // surasau visus zodzius ir ju koduotes atskirdamas juos t raide.
        {
            for (int j = 0; j < ManoRaides.visos.get(i).raide.length(); j++) {
              Irasimas.put((byte)ManoRaides.visos.get(i).raide.charAt(j));
              
                          if (Irasimas.position() >= 1000)
            {
                Irasimas.flip();
                outChannel.write(Irasimas);
                Irasimas.clear();
            }
            }

            for (int j = 0; j < ManoRaides.visos.get(i).kodavimas.length(); j++) {
                Irasimas.put((byte)ManoRaides.visos.get(i).kodavimas.charAt(j));
                                        if (Irasimas.position() >= 1000)
            {
                Irasimas.flip();
                outChannel.write(Irasimas);
                Irasimas.clear();
            }
            }
            Irasimas.put((byte)'t');
        }
        //outChannel
        Irasimas.flip();
        outChannel.write(Irasimas);
         Irasimas.clear();
        String dar_vienas_laikinas = "";
        Tikrinimui= "";
        while (inChannel.read(buffer) > 0) // kol nenureadina 0 baitu readina // pries sita while man reikia surasyti dekodavimo informacija i faila kazkoki nauja  // kazkas cia turbut negerai
        {
            buffer.flip(); // reikioa flippint kad galetumem naudoti
            for (int i = 0; i < buffer.limit(); i++) // kol bufferis nepasiekia limito kazka tai darom 
            {
                Tikrinimui += String.format("%8s", Integer.toBinaryString(buffer.get() & 0xFF)); // gaunam viena baito isdestyma su visais bitais ir israsom.
                Tikrinimui = Tikrinimui.replace(' ', '0'); // pakeiciam visus tarpus 0 kad nebutu  11111,o 00011111
//System.out.println(" tikrinimui t.y. ka nuskaitom :"+Tikrinimui);
                while (true) {

                    if (Tikrinimui.length() >= k) {

                        for (int h = 0; h < k; h++) {

                            laikinas += Tikrinimui.charAt(0); // cia man reikia patikrint kokia koduote, ir tada grazint ta koduote ir ta koduote uzrasyt ten kur krc reikia nu pyzdec zodz
                            Tikrinimui = Tikrinimui.substring(1);
                        }
                        
                        dar_vienas_laikinas += ManoRaides.GrazintiKoduote(laikinas);
                        //System.out.println(" dar vienas :"+  dar_vienas_laikinas);
                        laikinas = "";
                        if (Irasimas.position() >= 1000) {
                            Irasimas.flip();
                            outChannel.write(Irasimas);
                            Irasimas.clear();
                        }
                        while(dar_vienas_laikinas.length() >= 8) {
                            // tada man reikia substringa imest i bufferi paparsinta atgal i baitus
                            
                          //  System.out.println((byte) Integer.parseInt(dar_vienas_laikinas.substring(0, 8), 2) + " o turi but : "+ dar_vienas_laikinas.substring(0, 8));
                            
                            Irasimas.put((byte) ((byte) Integer.parseInt(dar_vienas_laikinas.substring(0, 8), 2)&0xFF));
                            dar_vienas_laikinas = dar_vienas_laikinas.substring(8);
                        }

                    } else {
                        break; // tada pabegam jei nebeliko vietos, taciau TODO: kad saugotu paskutinius simbolius jeigu netycia bus  nepilnas baitas
                    }

                    //TODO: paskaiciuoti kiek yra kokiu simboliu kai K yra kazkoks UPDATE : PADARYTA .
                }

            }
            buffer.clear(); // do something with the data and clear/compact it.
        }
        Irasimas.flip();
        outChannel.write(Irasimas);
        Irasimas.clear();
                for (int j = 0; j < dar_vienas_laikinas.length();j++) { // sitaSudaReikPatobulinti 
            Irasimas.put((byte)dar_vienas_laikinas.charAt(j));
                }
        Irasimas.flip();
        outChannel.write(Irasimas);
        Irasimas.clear();
        // kai padaro kodavimus, reikia gristi atgal i failo pradzia 
        //System.out.println(dar_vienas_laikinas);
       // System.out.println(Paskutiniai_baitai);
        inChannel.close(); // uzdarom viska
        aFile.close(); // udarom ivska
        outChannel.close();
        wFile.close();

        ManoRaides.Printout(); // isveda raide bitais ir t.t. zodz suprasi kai isvesi 
    }
    
}

