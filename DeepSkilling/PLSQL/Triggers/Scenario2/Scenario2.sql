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

-- Exercise 5: Triggers
-- Scenario 2

CREATE TABLE AuditLog
(   id  number generated always as identity primary key,
    msg varchar(200)
)


create or replace trigger LogTransaction
    after insert or delete or update on Transactions
    for each row
    begin
        if inserting then
            insert into AuditLog(msg)
            values ('Transaction inserted. ID = ' || :NEW.TransactionID);
        elsif updating then
            insert into AuditLog(msg)
            values ('Transaction updated. ID = ' || :NEW.TransactionID);
        elsif deleting then
            insert into AuditLog(msg)
            values ('Transaction deleted. ID = ' || :OLD.TransactionID);
        end if;


end;



begin
    INSERT INTO Transactions
    VALUES (
               11,
               2,
               SYSDATE,
               5000,
               'DEPOSIT'
        );


    UPDATE Transactions
    SET Amount = 7000
    WHERE TransactionID = 11;


    DELETE FROM Transactions
    WHERE TransactionID = 1;
    commit ;
end;