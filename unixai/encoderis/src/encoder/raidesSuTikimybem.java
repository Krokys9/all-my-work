/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

/**
 *
 * @author User
 */
public class raidesSuTikimybem {

    String raide;
    int tikimybe;
    String kodavimas;
    double tikimybePoKablelio;
    int logoritmo_aukstis;

    // koduote = 
    public raidesSuTikimybem(String raid, int tikimybe) {
        this.raide = raid;
        this.tikimybe = tikimybe;
        this.kodavimas = "";
        this.tikimybePoKablelio = 0;
    }

    public raidesSuTikimybem(String raid, int tikimybe, String kodavimas) {
        this.raide = raid;
        this.tikimybe = tikimybe;
        this.kodavimas = kodavimas;
        this.tikimybePoKablelio = 0;
    }

    public void print() {
        System.out.println("raide Bitais:" + this.raide + "  tikimybe : " + this.tikimybe + " koduote :" + this.kodavimas + " tikimybine koduote :" + this.tikimybePoKablelio
                + " logoritmo_aukstis : " + this.logoritmo_aukstis);
    }

    public void addChance() {
        this.tikimybe++;
    }

    public void setchanceForShennon(double isViso) {
        this.tikimybePoKablelio = (this.tikimybe / isViso);
    }

    public void setLogoritmo_aukstis(int aukstis) {
                   // System.out.println(aukstis);

        if(aukstis == 0)
        {
            this.logoritmo_aukstis =1;
        }
        else{
        this.logoritmo_aukstis = aukstis;
        }
    }

    public void prisiskirtiKoda(double temp) {
        
        for (int i = 0; i < this.logoritmo_aukstis; i++) {
            temp = temp * 2;

            if (temp >= 1) {
                temp -= 1;
                this.kodavimas += "1";
            } else {
                this.kodavimas += "0";
            }
        }
    }

}
