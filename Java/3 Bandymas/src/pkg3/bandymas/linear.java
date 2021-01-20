/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.bandymas;

/**
 *
 * @author User
 */
public class linear extends ThisIsParent {
    
    double left;
    double moneyInStart;
    
    public linear(double pinigai, int years, int months, double interest) {
        super(pinigai, years, months, interest);
    }
    @Override
    protected void Calculator()
    {
        left = this.money;
        moneyInStart= this.money / this.monthcount;
        for (int i = 0; i < this.monthcount; i ++)
        {
        
            this.amountLeft[i] = left;
            this.month[i]= i+1;
            this.interest[i] = left*this.monInterest;
            this.monthlyPayment[i] = this.money / this.monthcount +this.interest[i];
            total+=monthlyPayment[i];
            left-= moneyInStart;
            
        }
        super.round();
    }
        public void CountOnePayment()
    {
        Calculator();
        System.out.println(this.money);
        for(int i =0 ;i<monthcount;i++)
        {
           System.out.println(this.monthlyPayment[i]);
           System.out.println("  ");
           System.out.println(this.month[i]);
           System.out.println("  ");
           System.out.println("interest : " + Double.toString(this.interest[i])  );
           System.out.println("Amount left: " + Double.toString(this.amountLeft[i]));
        }
        System.out.println(this.total);
        System.out.println(this.monthcount);
        System.out.println(this.monInterest);

    }
    
    public double getInterest(int i)
    {
        return interest[i];
    }

    public int getMonthCount()
    {
        return monthcount;
    }

    public int getmonths(int i)
    {
        return month[i];
    }
    public double getAmountLeft(int i)
    {
        return amountLeft[i];
    }

    public double getTotal()
    {
        return total;
    }

    public double getLoanSize()
    {
        return money;
    }
        public double getMonthlyPayment(int i)
    {
        return monthlyPayment[i];
    }
}    

