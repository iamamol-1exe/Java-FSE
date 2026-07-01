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

-- Exercise 2: Error Handling
-- Scenario 1:


create or replace procedure  SafeTransferFunds(cust1 in number, cust2 in number,amount in number)
is
balance  number;
insufficientfunds exception;
begin
    select Customers.Balance into  balance from CUSTOMERS where CustomerID = cust1;

    if balance < amount then
        raise insufficientfunds;
    end if;

    update CUSTOMERS set Balance = BALANCE - amount where CustomerID = cust1;

    update CUSTOMERS set  Balance = BALANCE + amount where CustomerID = cust2;
    DBMS_OUTPUT.PUT_LINE('Transfer succesd'  || 'ammout : ' || amount );
    commit;

exception
    when insufficientfunds then
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds.');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Customer not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
end;


-- procedure call
begin
    SafeTransferFunds(1,2,1000);
end;

