/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shennon;

/**
 *
 * @author User
 */
public class raidesSuTikimybem {
    public char raide;
    int tikimybe;
    String kodavimas;
    
    // koduote = 
    public raidesSuTikimybem(char raid, int tikimybe)
            {
                this.raide = raid;
                this.tikimybe = tikimybe;
                this.kodavimas ="";
            }
    public raidesSuTikimybem(char raid, int tikimybe,String kodavimas)
    {
        this.raide = raid;
        this.tikimybe = tikimybe;
        this.kodavimas =kodavimas;
    }
    
}
