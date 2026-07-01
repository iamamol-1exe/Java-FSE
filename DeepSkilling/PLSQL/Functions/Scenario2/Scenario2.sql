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

-- Exercise 4: Functions
-- Scenario 2

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loanAmount IN NUMBER,
    p_interestRate IN NUMBER,
    p_years IN NUMBER
)
    RETURN NUMBER
    IS
    v_monthlyRate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN

    v_monthlyRate := (p_interestRate / 12) / 100;
    v_months := p_years * 12;

    IF v_monthlyRate = 0 THEN
        RETURN ROUND(p_loanAmount / v_months, 2);
    END IF;

    -- EMI Formula
    v_emi := (p_loanAmount * v_monthlyRate *
              POWER(1 + v_monthlyRate, v_months)) /
             (POWER(1 + v_monthlyRate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;


SELECT LoanID,
       CalculateMonthlyInstallment(
               LoanAmount,
               InterestRate,
               MONTHS_BETWEEN(EndDate, StartDate) / 12
       ) AS Monthly_Installment
FROM Loans;
