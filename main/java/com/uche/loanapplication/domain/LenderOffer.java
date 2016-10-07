package main.java.com.uche.loanapplication.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class to store the Loan Offer provided by the user
 * Created by uche ojukwu on 10/5/2016.
 */
public class LenderOffer {

    private Integer amountOffered;
    private Double interestRate;

    public LenderOffer(Integer amt, double rate){
        amountOffered = amt;
        interestRate = rate;
    }

    public Integer getAmt(){
        return amountOffered;
    }

    public Double getRate(){
        return interestRate;
    }

//To sort the List of Loan Offers based on interest rate field
    public static void sort(final String field, List<LenderOffer> itemLocationList) {

        Collections.sort(itemLocationList, new Comparator<LenderOffer>() {
            @Override
            public int compare(LenderOffer o1, LenderOffer o2) {
                if(field.equalsIgnoreCase("interestRate")) {
                    return o1.interestRate.compareTo(o2.interestRate);
                } else
                    throw new IllegalArgumentException("Invalid Parameter .");
            }
        });
    }
}
