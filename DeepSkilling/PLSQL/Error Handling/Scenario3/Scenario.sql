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
-- Scenario 3

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerId IN NUMBER,
    p_name       IN VARCHAR2,
    p_dob        IN DATE,
    p_balance    IN NUMBER
)
    IS
BEGIN
    INSERT INTO Customers (
        CustomerID,
        Name,
        DOB,
        Balance
    )
    VALUES (
               p_customerId,
               p_name,
               p_dob,
               p_balance
           );
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
                'Error: Customer with ID ' || p_customerId || ' already exists.'
        );

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

BEGIN
    AddNewCustomer(
            101,
            'Amol',
            DATE '2002-05-10',
            5000
    );
END;
/