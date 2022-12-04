-- Creating the table Position --
CREATE TABLE Position(PosID number(10) PRIMARY KEY, Pos_Name varchar2(20), Pos_Description varchar2(200));

-- Creating the table Specialty --
CREATE TABLE Specialty(Spec_ID number(10) PRIMARY KEY, Spec_Name varchar2(20), Spec_Description varchar2(200), CHECK( Spec_Name IN ('ENT', 'Cardiology', 'Neuorology')));

-- Creating the table User Type --
CREATE TABLE User_Type(UserType_ID number(10) PRIMARY KEY, UserType_Name varchar2(20), UserType_Description varchar2(200));

-- Creating the table Topic Type --
CREATE TABLE Topic_Type(TType_ID number(10) PRIMARY KEY, T_Name varchar2(50), T_Description varchar2(200), CHECK( T_NAME IN ('QUESTIONS', 'RECENT RESEARCH UPDATE', 'NEW MEDICATION
RELEASE', 'PATIENT OPINION', 'DISCUSSION', 'GENERAL INFORMATION')));

-- Creating the table User --
CREATE TABLE UserTable(UserName varchar2(10) PRIMARY KEY, pass varchar2(25), Date_Created DATE, FName varchar2(10), LName varchar2(10), 
UserType_ID REFERENCES User_Type(UserType_ID), AGE INT, GENDER char, CHECK( AGE >= 18), CHECK(Gender IN ('M', 'F')));

-- Creating the table Doctor --
CREATE TABLE Doctor(Doc_ID number(10) PRIMARY KEY, Doc_BioData varchar2(20),PosID REFERENCES Position(PosID), 
Spec_ID REFERENCES Specialty(Spec_ID), UserName REFERENCES UserTable(UserName));

-- Creating the table Topic --
CREATE TABLE Topic(T_ID number(10) PRIMARY KEY, Date_Created DATE,  Approved varchar2(20), Title varchar2(20), Spec_ID REFERENCES Specialty(Spec_ID), 
Ttype_ID REFERENCES Topic_Type(TType_ID), UserName REFERENCES UserTable(UserName));


-- Creating the table Reply --
CREATE TABLE Reply(Rep_ID number(10), Reply varchar2(20), Reply_Date DATE, T_ID REFERENCES Topic(T_ID), UserName REFERENCES UserTable(UserName));

-- Creating the table Patient --
CREATE TABLE Patient(Pat_ID number(10) PRIMARY KEY, Pat_Condition varchar2(20), UserName REFERENCES UserTable(UserName));

-- Creating the table Rating --
CREATE TABLE Rating(Rat_ID number(10) PRIMARY KEY, Rat_Date DATE, Rat_Rating number(10), Rat_Comment varchar2(100), Pat_ID REFERENCES Patient(Pat_ID),
Doc_ID REFERENCES Doctor(Doc_ID), CHECK(Rat_Rating >= 1 and Rat_Rating <= 5));

-- Creating the table Medicince --
CREATE TABLE Medicine(Med_ID number(10) PRIMARY KEY, Med_Name varchar2(20), Med_Description varchar2(500), Med_Price number(10));

-- Creating the table Patient's Medicine --
CREATE TABLE Patient_Medicine(Start_Date DATE, End_Date DATE, Pat_ID REFERENCES Patient(Pat_ID), Med_ID REFERENCES Medicine (Med_ID));



