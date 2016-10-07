package main.java.com.uche.loanapplication.start;


import main.java.com.uche.loanapplication.domain.LenderOffer;
import main.java.com.uche.loanapplication.domain.LoanRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console based Loan Platform App.
 */
public class LoanPlatformApp {

    static LoanRequest loanRequest = new LoanRequest();
    static List<LenderOffer> lendersList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer optionSelected = -1;
        System.out.println("Welcome to the Crowd Sourcing Loan Platform !");
        System.out.println();

        while (optionSelected != 4) {
            optionSelected = getOptionFromUser(input);

            switch (optionSelected) {
                case 1:
                    enterLoanRequest(input);
                    break;
                case 2:
                    enterLoanOffer(input);
                    break;
                case 3:
                    if(loanRequest.getLoanAmount() != null){
                        enterIndentifier(input);
                    }else{
                        System.out.println("No Valid Loan Request Present in the system yet!");
                        optionSelected = -1;
                    }
                    break;
                case 4:
                    System.exit(1);
                default:
                    printErrorMsg();
            }
        }
    }

    //Presents user list of options to choose from, in case invalidmoption is chosen, the list will be presented again
    private static Integer getOptionFromUser(Scanner input) {
        Integer optionSelected;
        do {
            System.out.println("Please select one of the following option to proceed :");
            System.out.println("To create a loan request Press 1");
            System.out.println("To create a loan offer   Press 2");
            System.out.println("To get current offer     Press 3");
            System.out.println("To Exit                  Press 4");
            String option = input.next();
            try {
                optionSelected = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                optionSelected = -1;
            }
            if (optionSelected != 1 && optionSelected != 2 && optionSelected != 3 && optionSelected != 4) {
                optionSelected = -1;
                System.out.println("Not a valid input ! Please try again!");
            }
        } while (optionSelected == -1);
        return optionSelected;
    }

    //Contains logic to enable creation of a Loan Request based on user input , a unique loan identifier will be created and presented to the user
    //According to current functionality, system will support only one borrower if another is added the precious one will be erased automatically
    private static void enterLoanRequest(Scanner input) {
        System.out.println("Please enter the Loan Request details.");
        System.out.println("Amount : (in $)");
        loanRequest = new LoanRequest();
        String amount = input.next();
        try {
            loanRequest.setLoanAmount(Integer.parseInt(amount));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input! System will exit now.");
            System.exit(1);
        }
        System.out.println("Duration : (in days)");
        String duration = input.next();
        try {
            loanRequest.setLoanDuration(Integer.parseInt(duration));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input ! System will exit now.");
            System.exit(1);
        }

        System.out.println("Loan Request created successfully !");
        System.out.println("Loan Identifier : " + loanRequest.getLoanIdentifier().toString());
        System.out.println(loanRequest.toString());
    }

    //Calculates the Current Offer for the Loan Request based on user provided Loan Identifier
    //In case invalid identifier is entered, the system will ask the user to try again
    private static void enterIndentifier(Scanner input) {
        // calculate the disbursed loan details
        System.out.println("Please enter the Loan Identifier");
        String identifier;
        int intIdentier = 0;
        while (intIdentier != loanRequest.getLoanIdentifier().getId()) {
            try {
                identifier = input.next();
                intIdentier = Integer.parseInt(identifier);
                if(intIdentier != loanRequest.getLoanIdentifier().getId()){
                    System.out.println("Loan Identifier entered is not correct, Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid input ! Try again");
            }
        }
        CurrentLoanOfferCalculator.disbursedLoanDetails(lendersList, loanRequest);
    }

    private static void printErrorMsg() {
        System.out.println("Something went wrong ! Please start again.");
        System.exit(1);
    }

    // Creates a new loan offer for the user entered Loan amount and Interest Rate.
    //This loan offer is saved and will be considered for creating Current Offer when requested
    private static void enterLoanOffer(Scanner input) {
        System.out.println("Please enter the available Lenders detail");
        int lenderAmtInt = 0;

        double rate = 0.0;
        System.out.println("Amount offered by Lender : ");
        String lenderAmt = input.next();
        try {
            lenderAmtInt = Integer.parseInt(lenderAmt);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input! Try again..");
            System.exit(1);

        }
        System.out.println("Rate offered : ");
        String stringRate = input.next();
        try {
            rate = Double.parseDouble(stringRate);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid input! Try again..");
            System.exit(1);
        }

        LenderOffer l = new LenderOffer(lenderAmtInt, rate);
        lendersList.add(l);
        System.out.println("Lender added, length : " + lendersList.size());
    }

}
