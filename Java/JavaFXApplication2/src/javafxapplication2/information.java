/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

/**
 *
 * @author User
 */
public class information {
    private final double monthCount;
    private final double monthlyPayment;
    private final double interest;
    private final double month;
    private final double amountLeft;
    
    
    
    
   public information(Calculator Paskola, int i) {
        
        monthlyPayment = Paskola.getMonthPayment();
        monthCount = Paskola.getMonths() + Paskola.getYears() * 12 ;
        interest = Paskola.getInterest();
        month = Paskola.getMonths();
        amountLeft = 0;
  
    }

    
    
}
