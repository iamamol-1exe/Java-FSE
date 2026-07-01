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


-- CREATE TABLE Employees (
--     EmployeeID NUMBER PRIMARY KEY,
--     Name VARCHAR2(100),
--     Position VARCHAR2(50),
--     Salary NUMBER,
--     Department VARCHAR2(50),
--     HireDate DATE
-- );

-- Exercise 2: Error Handling
-- Scenario 2


create or replace procedure UpdateSalary(empID in number, hike in number)
is
prev_salary number;
hike_amount number;
begin
    select Salary into prev_salary from EMPLOYEES where EmployeeID = empID;
    hike_amount := prev_salary * (hike/100);
    DBMS_OUTPUT.PUT_LINE('Hike ammount : '|| hike_amount);
    update EMPLOYEES set SALARY = SALARY + hike_amount where EmployeeID = empID;
    DBMS_OUTPUT.PUT_LINE('Salary  Increased by  : '|| hike_amount);
    commit;
exception
    when NO_DATA_FOUND then
        DBMS_OUTPUT.PUT_LINE('No Employee found.');
    when Others  then
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
end;




begin
    UpdateSalary(1,5);
end;