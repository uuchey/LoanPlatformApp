package test.java.com.uche.loanapplication.api.impl;

import main.java.com.uche.loanapplication.domain.LoanRequest;
import main.java.com.uche.loanapplication.domain.LoanRequestId;
import main.java.com.uche.loanapplication.start.CurrentLoanOfferCalculator;
import main.java.com.uche.loanapplication.domain.LenderOffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CSLoanCreatorTest {
    private LoanRequest loanRequest;
    private List<LenderOffer> loanLenders;

    @Before
    public void setUp() throws Exception {
        loanLenders = new ArrayList<>();
        loanLenders.add(new LenderOffer(100,5));
        loanLenders.add(new LenderOffer(500,8.6));
        loanRequest = new LoanRequest(1000, 100);
    }

    @Test
    public void testCreateLoan(){
        //given multiple loan requests
        LoanRequest request1 =  new LoanRequest(22, 2);
        LoanRequest request2 =  new LoanRequest(23, 3);
        LoanRequest request3 =  new LoanRequest(24, 4);
        LoanRequest request4 =  new LoanRequest(25, 6);

        //when we create the requests
        LoanRequestId id1 = request1.getLoanIdentifier();
        LoanRequestId id2 =request2.getLoanIdentifier();
        LoanRequestId id3 =request3.getLoanIdentifier();
        LoanRequestId id4 =request4.getLoanIdentifier();

        //then , we should have unique ids for all the requests
        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);
        Assert.assertNotNull(id3);
        Assert.assertNotNull(id4);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id2, id3);
        Assert.assertNotEquals(id3, id4);
        Assert.assertNotEquals(id4, id1);
        Assert.assertNotEquals(id1, id2);


        System.out.println("id1 = " + id1);
        System.out.println("id2 = " + id2);
        System.out.println("id3 = " + id3);
        System.out.println("id4 = " + id4);

    }

    @Test
    public void testWithInsufficientAmount() throws Exception {
        CurrentLoanOfferCalculator.disbursedLoanDetails(loanLenders,loanRequest);
        Assert.assertEquals(8.0, CurrentLoanOfferCalculator.getAvailableAVR().doubleValue(),0.01);
        Assert.assertEquals(600, CurrentLoanOfferCalculator.getAvailableLoanAmt().intValue());
    }

    @Test
    public void testWithSufficientAmount() throws Exception {
        loanLenders.add(new LenderOffer(600,6));
        loanLenders.add(new LenderOffer(600,7));
        CurrentLoanOfferCalculator.disbursedLoanDetails(loanLenders,loanRequest);
        Assert.assertEquals(6.2, CurrentLoanOfferCalculator.getAvailableAVR().doubleValue(),0.01);
        Assert.assertEquals(1000, CurrentLoanOfferCalculator.getAvailableLoanAmt().intValue());

    }

}