CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);



CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Exercise 3: Procedure
-- Scenario 1

create or replace procedure ProcessMonthlyInterest(interestRate in number)
is
    interestAmount number;
begin
    for accs in (SELECT AccountID, CustomerID, Balance from ACCOUNTS)
    loop
            interestAmount := accs.Balance * ( interestRate /100);
        update ACCOUNTS set BALANCE = BALANCE + interestAmount where AccountID = accs.AccountID;
        DBMS_OUTPUT.PUT_LINE('Interest added for customer id :' || accs.CustomerID || 'intrest amount :' || interestAmount);
    end loop;
    commit;
exception
    when OTHERS then
        rollback ;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
end;

begin
    ProcessMonthlyInterest(1);
end;


