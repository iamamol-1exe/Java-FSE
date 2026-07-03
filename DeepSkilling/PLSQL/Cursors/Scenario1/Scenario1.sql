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

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT TransactionID,
               AccountID,
               TransactionDate,
               Amount,
               TransactionType
        FROM Transactions
        WHERE TRUNC(TransactionDate,'MM') = TRUNC(SYSDATE,'MM');

    v_tid Transactions.TransactionID%TYPE;
    v_acc Transactions.AccountID%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
            INTO v_tid, v_acc, v_date, v_amount, v_type;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
                'Account: ' || v_acc ||
                ' Transaction: ' || v_tid ||
                ' Date: ' || TO_CHAR(v_date,'DD-MON-YYYY') ||
                ' Amount: ' || v_amount ||
                ' Type: ' || v_type
        );
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/