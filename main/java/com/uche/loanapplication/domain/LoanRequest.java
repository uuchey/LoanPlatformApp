package main.java.com.uche.loanapplication.domain;

import java.util.Random;

/**
 * Class to store the Loan Request created by the user
 * Each instance will have a unique Identifier that will be used to create Current Loan Offer
 * Created by uuchey  on 10/6/2016.
 */
public class LoanRequest {
    private Integer loanAmt;
    private Integer loanDuration;
    private LoanRequestId identifier;
    private static Random identifierGenerator = new Random(4);
    private static int initialIdentifier = Math.abs(identifierGenerator.nextInt());

    public LoanRequest(){
        createRandomIdentifier();
    }


    public LoanRequest(Integer amt, Integer duration){
        loanAmt = amt;
        loanDuration = duration;
        createRandomIdentifier();
    }

    public Integer getLoanAmount() {
        return loanAmt;
    }

    public void setLoanAmount(Integer loanAmt) {
        this.loanAmt = loanAmt;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanRequest that = (LoanRequest) o;

        if (loanAmt != null ? !loanAmt.equals(that.loanAmt) : that.loanAmt != null) return false;
        return loanDuration != null ? loanDuration.equals(that.loanDuration) : that.loanDuration == null;

    }

    @Override
    public int hashCode() {
        int result = loanAmt != null ? loanAmt.hashCode() : 0;
        result = 31 * result + (loanDuration!= null ? loanDuration.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "Loan Amount : $"+ loanAmt + " Loan duration : " + loanDuration+ " days.";
    }

    public void createRandomIdentifier(){
        identifier = new LoanRequestId(initialIdentifier++);
    }

    public LoanRequestId getLoanIdentifier(){
        return identifier;
    }
}
