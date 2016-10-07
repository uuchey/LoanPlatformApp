package main.java.com.uche.loanapplication.api.impl;

import main.java.com.uche.loanapplication.api.LoanCreator;
import main.java.com.uche.loanapplication.domain.LoanRequest;
import main.java.com.uche.loanapplication.domain.LoanRequestId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by uuchey  on 10/6/2016.
 * This test class tests 2 scenarios :
 * 1. When requested loan can be disbursed completely
 * 2. When requested loan can be disbursed partially
 */
public class CSLoanCreator implements LoanCreator {

    private Map<LoanRequestId, LoanRequest> loanRequestStore = Collections.synchronizedMap(new HashMap<>());

    @Override
    public LoanRequestId createLoan(LoanRequest loanRequest) {
        LoanRequestId loanId = generateNewLoanId();
        loanRequestStore.put(loanId, loanRequest);
        return loanId;
    }

    @Override
    public LoanRequest getLoanRequest(LoanRequestId requestId) {
        return loanRequestStore.get(requestId);
    }

    synchronized LoanRequestId  generateNewLoanId(){
        Integer id = 1;
        TreeSet<LoanRequestId> ids = new TreeSet<>(loanRequestStore.keySet());
        if (!ids.isEmpty()){
            id = ids.last().getId()+1;
        }
        return new LoanRequestId(id);
    }
}
