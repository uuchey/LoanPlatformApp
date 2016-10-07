package main.java.com.uche.loanapplication.api;

import main.java.com.uche.loanapplication.api.impl.LoanOffer;
import main.java.com.uche.loanapplication.domain.LenderOffer;

import java.util.List;

public interface OfferCreator {

    /**
     *  Given a lender offer, this method will persist and return an Id
     *  for the request.
     *
     * @param lenderOffer
     * @return
     */

    Integer createLoanOffer(LoanOffer lenderOffer);


    List<LoanOffer> getAvailableOffers();

}
