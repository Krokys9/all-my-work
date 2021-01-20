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
public class DataForMe {

    public int getMonthCount() {
        return monthCount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getInterest() {
        return interest;
    }

    public int getMonth() {
        return month;
    }

    public double getAmountLeft() {
        return amountLeft;
    }

    public DataForMe(Anuino lolu, int i) {
        monthCount = i;
        monthlyPayment = lolu.monthlyPayment[i];
        interest = lolu.interest[i];
        month = lolu.month[i];
        amountLeft = lolu.amountLeft[i];
    }
        public DataForMe(linear lolu, int i) {
        monthCount = i;
        monthlyPayment = lolu.monthlyPayment[i];
        interest = lolu.interest[i];
        month = lolu.month[i];
        amountLeft = lolu.amountLeft[i];
    }
    private final int monthCount;
    private final double monthlyPayment;
    private final double interest;
    private final int month;
    private final double amountLeft;
}
