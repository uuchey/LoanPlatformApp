package main.java.com.uche.loanapplication.start;

import main.java.com.uche.loanapplication.domain.LenderOffer;
import main.java.com.uche.loanapplication.domain.LoanRequest;

import java.util.List;

/**
 * Helper class to calculate the Current Offer for Requested Loan with lowest Combined Interest Rate
 *
 */
public class CurrentLoanOfferCalculator {
    private static Integer availableLoanAmt;
    private static Double availableAVR;

    public static void disbursedLoanDetails(List<LenderOffer> lenders, LoanRequest requestedAmt){
        availableLoanAmt = 0;
        LenderOffer.sort("interestRate",lenders);
        availableAVR = 0.0;
        double cumulativeSum = 0;

        for(LenderOffer lender : lenders){
            int tempAmt = availableLoanAmt + lender.getAmt();
            if(tempAmt < requestedAmt.getLoanAmount()) {
                availableLoanAmt += lender.getAmt();
                cumulativeSum +=lender.getAmt()*lender.getRate();
            }else{
                //Complete amount of lender is not required, we need only a part of it
                int remainingAmt = requestedAmt.getLoanAmount() -availableLoanAmt;
                cumulativeSum += remainingAmt*lender.getRate();
                availableLoanAmt+=remainingAmt;
                break;
            }
        }
        availableAVR = cumulativeSum/availableLoanAmt;
        System.out.println("Available Loan : " + availableLoanAmt);
        System.out.println("Available APR : " + availableAVR);
    }

    public static Integer getAvailableLoanAmt(){
        return availableLoanAmt;
    }

    public static Double getAvailableAVR(){
        return availableAVR;
    }


}
