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
public class Calculator {

    Calculator(Calculator Paskola, int i) {
        
        
    }

    String returnText() {
        if (monthForText != months)
       return "Month " + monthForText + " money : " + totalAmount /((years * 12)+ months) + " "; 
        else 
        {
            monthForText = 0;
            return "";
        }
    }
    private double totalAmount;
    private double years;
    private double months;
    private double interest;
    private boolean typeOfInterest = false; // " is advanced"
    private int monthForText= 0; 
    
    Calculator(double totalAmount, double years, double months, double interest, boolean typeofinterest)
    {
        this.totalAmount = totalAmount;
        this.years = years;
        this.months = months;
        this.interest = interest;
        this.typeOfInterest = typeofinterest;
        
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public void setMonths(double months) {
        this.months = months;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setTypeOfInterest(boolean typeOfInterest) {
        this.typeOfInterest = typeOfInterest;
    }
    
//    
//    double Demo ()
//    {
//        
//        return totalAmount * ( (years * 12 + months) * interest /12 ); // simply linear 
//        
//    }
//    double demoAdvanced() // counts fulll price of it P.S. skaiciuoja total, koki reiks po viso laikotarpio grazint. T.Y. neveikianti sistema
//    {
//        return totalAmount *  (Math.pow(interest/12, (years * 12 + months))); /// IS VBE FORMULYNO.
//    }
//    
//    double anuiteno ()
//    {
//        return totalAmount * (((interest/12) * Math.pow( interest/12 +1, (years * 12 + months)))/Math.pow( interest/12 +1, (years * 12 + months))-1) ;
//    }
//  
//    double monthPayment()
//    {
//        return anuiteno() / (years * 12 + months);
//    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getYears() {
        return years;
    }

    public double getMonths() {
        return months;
    }

    public double getInterest() {
        return interest;
    }

    public boolean isTypeOfInterest() {
        return typeOfInterest;
    }
        public double getMonthPayment() {
            
        return 100;
    }
}
