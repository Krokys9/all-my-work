package pkg3.bandymas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
abstract  class ThisIsParent {
    double money;
    int[] month;
    int monthcount;
    double[] monthlyPayment;
    double[] interest;
    double[] amountLeft;
    double total;
    double monInterest;
    public ThisIsParent(double pinigai, int years, int months, double interest)
    {
        this.money = pinigai;
        this.monthcount = years*12+ months;
        this.monInterest = (interest / 100) / 12;
        this.monthlyPayment = new double[monthcount];
        this.interest = new double[monthcount];
        this.amountLeft= new double[monthcount];
        this.month = new int [monthcount];
    }
    
  protected void round() 
  {
      for ( int i = 0 ; i < monthcount ; i ++)
      {
           monthlyPayment[i] = (double) Math.round(monthlyPayment[i]*100)/100;
           amountLeft[i] = (double) Math.round(amountLeft[i]*100)/100;
           interest[i] = (double) Math.round(interest[i]*100)/100;
      }
        total =(double) Math.round(total*100)/100;
        money = (double) Math.round(money*100)/100; 
   }
  abstract void Calculator();
      
  }
    
