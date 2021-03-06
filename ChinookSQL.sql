--Task 2.1a Select all records from the Employee table.
SELECT * FROM CHINOOK.EMPLOYEE;

--Task 2.1b Select all records from the Employee table where last name is King.
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.LASTNAME = 'King';

--Task 2.1c Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.FIRSTNAME = 'Andrew' AND CHINOOK.EMPLOYEE.REPORTSTO IS NULL;

--Task 2.2a Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY CHINOOK.ALBUM.TITLE DESC;

--Task 2.2b Select first name from Customer and sort result set in ascending order by city
SELECT CHINOOK.CUSTOMER.FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CHINOOK.CUSTOMER.CITY ASC;

--Task 2.3a Insert two new records into Genre table 
INSERT INTO CHINOOK.GENRE (GENREID, NAME) VALUES (26, 'ALTERNATE ROCK');
INSERT INTO CHINOOK.GENRE (GENREID, NAME) VALUES (27, 'ROCK');

--Task 2.3B Insert two new records into Employee table
INSERT INTO CHINOOK.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate,
Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (9, 'TRUCK', 'SKI', 'DIRECETOR', TO_DATE('1982-2-25 00:00:00','yyyy-mm-dd hh24:mi:ss'),
TO_DATE('2005-8-24 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11218 TRUCKLAND Ave ', 'BROOKLYN', 'NY', 'UNITED STATES',
'T15 215', '+1 (780) 123-4567', '+1 (780) 123-4568', 'TRUCKSKI@chinookcorp.com');

INSERT INTO CHINOOK.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate,
Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (10, 'SALLY', 'Andrew', 'WORKER', TO_DATE('1993-05-22 00:00:00','yyyy-mm-dd hh24:mi:ss'),
TO_DATE('2014-09-13 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11020 OCEAN Ave', 'QUEENS', 'NY', 'UNITED STATES', 
'Q1Q 4K2', '+1 (780) 987-6543', '+1 (780) 987-6542', 'SALLYANDREW@chinookcorp.com');

--Task 2.3C Insert two new records into Customer table
INSERT INTO CHINOOK.Customer (CustomerId, FirstName, LastName, Company, Address, City, State,
Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (60, 'ADAM', 'SULLIVAN', 'BORING COMPANY',
'999 CLOUD9', 'CLOUD', 'MI', 'UNITED STATES', '123-232',
'+1 (999) 999-5555', '+1 (999) 999-6666', 'ASULLIVAN@BORINGCOMPANUY.com', 3);

INSERT INTO CHINOOK.Customer (CustomerId, FirstName, LastName, Company, Address, City, State,
Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (61, 'BOB', 'QWERT', 'FUN COMPANY',
'000 CLOUD0', 'CLOUD', 'MI', 'UNITED STATES', '123-245',
'+1 (111) 555-9999', '+1 (111) 999-6666', 'BQWERT@FUNCOMPANUY.com', 6);

--Task 2.4a Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER SET CHINOOK.CUSTOMER.FIRSTNAME = 'Robert', CHINOOK.CUSTOMER.LASTNAME = 'Walter' 
WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Aaron' AND CHINOOK.CUSTOMER.LASTNAME = 'Mitchell';

--Task 2.4b Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�		
UPDATE CHINOOK.ARTIST SET CHINOOK.ARTIST.NAME = 'CCR' WHERE CHINOOK.ARTIST.NAME = 'Creedence Clearwater Revival'; 

--Task 2.5 Select all invoices with a billing address like �T%� 
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.BILLINGADDRESS LIKE 'T%';

--Task 2.6a Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.TOTAL BETWEEN 15 AND 50;

--Task 2.6b Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.HIREDATE BETWEEN TO_DATE('2003-6-1','yyyy-mm-dd') AND TO_DATE('2004-3-1','yyyy-mm-dd');

--Task 2.7 Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CHINOOK.INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM CHINOOK.INVOICE WHERE CUSTOMERID = 
(SELECT CUSTOMERID FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

DELETE FROM CHINOOK.INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

DELETE FROM CHINOOK.CUSTOMER WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Robert' AND CHINOOK.CUSTOMER.LASTNAME = 'Walter';

--Task 3.1a Create a function that returns the current time.
CREATE OR REPLACE FUNCTION FNC_RETURN_CURRENT_TIME
RETURN VARCHAR2 IS CURRTIME VARCHAR2(50);
BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH.MI.SS') INTO CURRTIME FROM DUAL;
    RETURN CURRTIME;
END FNC_RETURN_CURRENT_TIME;
/
SELECT FNC_RETURN_CURRENT_TIME FROM DUAL;

-- Task 3.1b create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION FNC_LENGTH_NAME
RETURN NUMBER IS NAME_LENGTH NUMBER;
BEGIN
    SELECT DATA_LENGTH INTO NAME_LENGTH FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='MEDIATYPE' AND COLUMN_NAME = 'NAME';
    RETURN NAME_LENGTH;
END FNC_LENGTH_NAME;
/
SELECT FNC_LENGTH_NAME FROM DUAL;

--Task 3.2a Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION FNC_AVG_INVOICES
RETURN INTEGER IS AVG_INVOICES INTEGER;
BEGIN
    SELECT AVG(CHINOOK.INVOICE.TOTAL) INTO AVG_INVOICES FROM CHINOOK.INVOICE;
    RETURN AVG_INVOICES;
END FNC_AVG_INVOICES;
/
SELECT FNC_AVG_INVOICES FROM DUAL;

--TASK 3.2b Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION FNC_MOST_EXPENSIVE_TRACK
RETURN VARCHAR2 IS MOST_EXPENSIVE VARCHAR2(100);
BEGIN
    SELECT CHINOOK.TRACK.NAME INTO MOST_EXPENSIVE 
    FROM CHINOOK.TRACK WHERE CHINOOK.TRACK.UNITPRICE = (SELECT MAX(CHINOOK.TRACK.UNITPRICE) 
    FROM CHINOOK.TRACK) AND ROWNUM = 1;
    RETURN MOST_EXPENSIVE;
END FNC_MOST_EXPENSIVE_TRACK;
/
SELECT FNC_MOST_EXPENSIVE_TRACK FROM DUAL;

--Task 3.3a Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION FNC_AVG_PRICE_INVOICELINE
RETURN NUMBER IS AVG_PRICE NUMBER;
BEGIN
    SELECT AVG(CHINOOK.INVOICELINE.UNITPRICE) INTO AVG_PRICE FROM CHINOOK.INVOICELINE;
    RETURN ROUND(AVG_PRICE, 2);
END FNC_AVG_PRICE_INVOICELINE;
/
SELECT FNC_AVG_PRICE_INVOICELINE FROM DUAL;

--Task 3.4 Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION FNC_EMPLOYEES_BORN_AFTER_1968
RETURN SYS_REFCURSOR
IS S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT EMPLOYEEID, FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE 
    WHERE BIRTHDATE > TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN S;
END;


DECLARE 
S SYS_REFCURSOR;
EMPLOYEEID CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE;
FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
 S := FNC_EMPLOYEES_BORN_AFTER_1968;
    LOOP
        FETCH S INTO EMPLOYEEID, FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' ||EMPLOYEEID || ': ' ||FIRSTNAME||' IS FIRST NAME, '||LASTNAME||' IS LAST NAME.');
    END LOOP;
    CLOSE S;
END;


--Task 4.1 Create a stored procedure that selects the first and last names of all the employees.
-- GET AN ERROR IF IDENTIFIER NAME IS TOO LONG
CREATE OR REPLACE PROCEDURE SP_FIRSTNAME_LASTNAME(S_FIRSTNAME_LASTNAME OUT SYS_REFCURSOR)
IS S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME,LASTNAME FROM CHINOOK.EMPLOYEE;
    S_FIRSTNAME_LASTNAME:= S;
END;

DECLARE 
S SYS_REFCURSOR;
FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SP_FIRSTNAME_LASTNAME(S);
    LOOP
        FETCH S INTO FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' IS FIRST NAME, '||LASTNAME||' IS LAST NAME.');
    END LOOP;
    CLOSE S;
END;

--Task 4.2a Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE SP_UPDATE_EMPLOYEE(EID IN chinook.employee.employeeid%type,
F IN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE, L  CHINOOK.EMPLOYEE.LASTNAME%TYPE, B  CHINOOK.EMPLOYEE.BIRTHDATE%TYPE,
A  CHINOOK.EMPLOYEE.ADDRESS%TYPE, E  CHINOOK.EMPLOYEE.EMAIL%TYPE)
IS 
BEGIN
    UPDATE CHINOOK.EMPLOYEE SET FIRSTNAME = F, LASTNAME = L, BIRTHDATE = B,
    ADDRESS = A, EMAIL = E WHERE EMPLOYEEID = EID;
END;


--Task 4.2b Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE SP_MANAGERS_EMPLOYEE(EID IN NUMBER, S_MAN OUT SYS_REFCURSOR)
IS S OUT SYS_REFCURSOR
BEGIN
    
    OPEN S FOR
    SELECT FIRSTNAME,LASTNAME FROM CHINOOK.EMPLOYEE, WHERE (SELECT EMPLOYEEID
    FROM CHINOOK.EMPLOYEE WHERE REPORTSTO = 'MANAGER');
    S_MAN := S;

END;

--Task 4.3 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE SP_NAME_COMP_CUSTOMER(C IN NUMBER,S OUT SYS_REFCURSOR)
IS S_TEMP SYS_REFCURSOR;
BEGIN
    OPEN S_TEMP FOR
    SELECT FIRSTNAME,LASTNAME,COMPANY FROM CHINOOK.CUSTOMER WHERE CUSTOMERID = C;
    S:= S_TEMP;
END;

DECLARE 
S SYS_REFCURSOR;
FIRSTNAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
LASTNAME CHINOOK.CUSTOMER.LASTNAME%TYPE;
COMPANY CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN
    SP_NAME_COMP_CUSTOMER(1,S);
    LOOP
        FETCH S INTO FIRSTNAME, LASTNAME, COMPANY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' IS FIRST NAME, '||LASTNAME||' IS LAST NAME ' || 'COMPANY: ' ||COMPANY);
    END LOOP;
    CLOSE S;
END;



--TASK 5 Create a transaction that given a invoiceId will delete that invoice.
CREATE OR REPLACE PROCEDURE SP_DELETE_INVOICE(I IN NUMBER)
IS 
BEGIN
    DELETE FROM CHINOOK.INVOICELINE WHERE INVOICEID = I;
    DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = I;
END;



--TASK 6.1a Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_AFTER_EMPLOYEE_INSERT
AFTER INSERT ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE CREATED. HELLO ' || :NEW.FIRSTNAME ||' '|| :NEW.LASTNAME || '!');
END;

--Task 6.2b Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_AFTER_ALBUM_INSERT
AFTER INSERT ON CHINOOK.ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('ALBUM CREATED: ' || :NEW.TITLE ||' '|| :NEW.ARTISTID || '!');
END;

--Task 6.1c Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_AFTER_CUSTOMER_DELETE
AFTER DELETE ON CHINOOK.CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED GOODBYE ' || :OLD.FIRSTNAME || ' ' || :OLD.LASTNAME);
END;

--Task 7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT INVOICEID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME
FROM CHINOOK.CUSTOMER
INNER JOIN
CHINOOK.INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

--Task 7.2 Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICEID, TOTAL
FROM CHINOOK.CUSTOMER
OUTER JOIN
CHINOOK.INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID

--Task 7.3 Create a right join that joins album and artist specifying artist name and title
SELECT ARTIST.NAME, ALBUM.TITLE
FROM CHINOOK.ALBUM
RIGHT JOIN
CHINOOK.ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID

--Task 7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM CHINOOK.ALBUM
CROSS JOIN
CHINOOK.ARTIST
ORDER BY ARTIST.NAME ASC;

--Task 7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.EMPLOYEEID, B.REPORTSTO
FROM CHINOOK.EMPLOYEE A, CHINOOK.EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;


