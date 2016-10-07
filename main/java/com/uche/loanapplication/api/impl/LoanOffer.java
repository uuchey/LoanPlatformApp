package main.java.com.uche.loanapplication.api.impl;

import main.java.com.uche.loanapplication.api.LoanCreator;
import main.java.com.uche.loanapplication.api.OfferCreator;
import main.java.com.uche.loanapplication.domain.CurrentOffer;
import main.java.com.uche.loanapplication.domain.LenderOffer;
import main.java.com.uche.loanapplication.domain.LoanRequest;
import main.java.com.uche.loanapplication.domain.LoanRequestId;

import java.util.List;

/**
 * Created by uuchey on 10/6/2016.
 */
public class LoanOffer {
    private LoanCreator loanCreator = new CSLoanCreator();
    private OfferCreator offerCreator = new CSOfferCreator();

    public CurrentOffer getCurrent(LoanRequestId requestId){

        //get the loam request
        LoanRequest loanRequest = loanCreator.getLoanRequest(requestId);

        //get all the offers available in our offer repo
        List<LoanOffer> availableOffers = offerCreator.getAvailableOffers();

        //Now calculate the amount we can offer
        return null;
    }

}

