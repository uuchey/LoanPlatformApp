package main.java.com.uche.loanapplication.api;

import main.java.com.uche.loanapplication.domain.LoanRequest;
import main.java.com.uche.loanapplication.domain.LoanRequestId;

/**
 * Created by uuchey  on 10/6/2016.
 */
public interface LoanCreator {
    /**
     *  Given a loan request, this method will persist and return an Id
     *  for the request.
     *
     * @param loanRequest
     * @return
     */

    LoanRequestId createLoan(LoanRequest loanRequest);


    LoanRequest getLoanRequest(LoanRequestId requestId);


}
