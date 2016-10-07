This README file explains how to use the program Crowd-Sourcing Loan Platform.
This is Version 1.0 of the program

About
------------
This is crowd-sourcing loan platform which will allow borrowers to take out loans that are made up of multiple loans from different lenders.
Users who want to borrow money (borrowers) will enter a loan request, which consists of the amount they want to borrow and the duration they want to borrow the money for. Users who want to lend money (lenders) will enter the amount of money they are willing to lend towards this loan and the interest rate (APR) they require.

Installation - RUN IN AN IDE
-----------

Extract the zipped file "LoanPlatform.zip" into your desired location.
Go to your selected IDE, such as Eclipse or IntelliJ, and import the project (extracted zipped file) into your IDE
Run the main class "LoanPlatformApp.main()" found in path src/main/java/com.uche.loanapplication/start and follow the instructions on screen

Design
-----------
Three folders were created in src/main
The API folder contains the API which the system will work through to provide the functionality to create a loan request,
create a loan offer, and get current offers.
It also contains the three classes needed in defining the terms for the system: The loan Creator, Offer Creator and Loan Offer
The domain folder contains the business logic for the three main functionalities of the system, This includes:
The LoanRequestId which will be generated and assigned for every entry of request made. The id is incremental to avoid duplication of ids.
The .../start folder contains the main class to run the application along with the calculator to get the current loan offer
The CurrentLoanOfferCalculator will ensure the Best Current Offer is calculated adequately for the user. Outputing the lowest combined interest rate
The main class (LoanPlatformApp.main()) contains the user input together with some validations.
The test folder contains three tests in one class.
The first test ensures that Loans are created.
The second test ensures that ids are assigned and stored to each request
The final test ensures there is sufficient amount available to give out the loan.

When the main class (LoanPlatformApp) runs, it requests the user to identify the action they which to take, giving each action an id.
It stores all Loan offers registered and awaits a loan request.
When the loan request is made, it searches if there is sufficient amount in store to satisfy the loan request.
The current best offer is kept up to date without having to refresh the system.

Assumptions
-----------

No ID should be duplicated
A Loan offer should be present before a request can be made

Output
-----------
Enter a Loan Request:
Amount 1000; Duration: 100

->Loan Request created successfully !
->Loan Identifier : LoanRequestId {id = 1157023573}


Enter Loan Offer (This is required to get a current offer)
Amount: 100; APR: 5
->Lender Added.

Amount: 500; APR: 8.6
->Lender Added.

Get current offer from your loan request (Using Loan Request Identifier)
Enter ID: 1157023573

->Available Loan: 600
->Available APR: 8.0

Overview of Client Server Interaction/Architecture
-----------------------------------------------------
In other to develop the web application, I would use Tomcat as my Web Server to handle serving dynamic content.
On top of the server, I would have a web framework, preferably Spring. This is because I can define objects to be used in my forms and then when they are submitted the entire object is passed back so there is less work. There is also Spring security which I can use for Auth. Then will add the ORM and a build tool such as Maven to build externally from the IDE.
On my front 


Development.
-------------

This solution designed and developed by Uche Ojukwu. 


