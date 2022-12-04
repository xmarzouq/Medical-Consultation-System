
-- inserting 3 types of users into user type table with format: UserType_ID, UserType_Name, UserType_Description;
INSERT INTO USER_TYPE VALUES(1, 'ADMIN', 'ADMIN USER');
INSERT INTO USER_TYPE VALUES(2, 'DOCTOR', 'DOCTOR USER');
INSERT INTO USER_TYPE VALUES(3, 'PATIENT', 'PATIENT USER');

-- inserting values into position table with format: PosID, Pos_Name, Pos_Description
INSERT INTO Position VALUES(1,'Manager', 'Supervise the doctors');
INSERT INTO Position VALUES(2,'Head of Cardiology', 'The lead doctor in surgeons');
INSERT INTO Position VALUES(3,'Head of ENT', 'The lead doctor of ENT');
INSERT INTO Position VALUES(4,'Head of Neuorology', 'The lead doctor of Neurology');
INSERT INTO Position VALUES(5, 'General', 'General Physician');

-- inserting values into doctor's specialty table with format: Spec_ID, Spec_Name, Spec_Description 
INSERT INTO Specialty VALUES(1, 'ENT', 'Ear, Nose, and Throat doctor');
INSERT INTO Specialty VALUES(2, 'Neuorology', 'Neurons Doctor');
INSERT INTO Specialty VALUES(3, 'Cardiology', 'Cardiology Doctor');

-- inserting values into topic type table with format: TopicType_ID, Topic_Name, Topic_Description
INSERT INTO Topic_Type VALUES(1,'QUESTIONS', 'QUESTIONS TO DOCTORS');
INSERT INTO Topic_Type VALUES(2,'DISCUSSION', 'DISCUSSIONS ABOUT MEDICAL TOPICS');
INSERT INTO Topic_Type VALUES(3,'GENERAL INFORMATION', 'SHARING OF INFORMATIONS');
INSERT INTO Topic_Type VALUES(4,'RECENT RESEARCH UPDATE', 'THE LATEST NEWS ABOUT MEDICINE');
INSERT INTO Topic_Type VALUES(5,'PATIENT OPINION', 'PATIENTS OPINIONS ABOUT DOCTORS AND MEDICINES');

-- inserting values into medicines table with format: Med_ID, Med_Name, Med_Description, Med_Price 
INSERT INTO MEDICINE VALUES(1, 'PANADOL', 'MEDICINE FOR HEADACHE', 5);
INSERT INTO MEDICINE VALUES(2, 'PANADOL NIGHT', 'MEDICINE TO SLEEP', 10);
INSERT INTO MEDICINE VALUES(3, 'ibuprofen', 'MEDICINE FOR SORE THROAT', 15);
INSERT INTO MEDICINE VALUES(4, 'Firazyr', 'MEDICINE FOR WEAK IMMUNE SYSTEM', 25);
INSERT INTO MEDICINE VALUES(5, 'Vicodin ', 'MEDICINE FOR BODY PAIN', 30);
INSERT INTO MEDICINE VALUES(6, 'Albuterol', 'MEDICINE FOR LUNG PROBLEMS', 20);


-- inserting users into user table with format: UserName, password, Date_Created, FName, LName, UserType_ID, Age, Gender 
INSERT INTO UserTable VALUES('AhmadUser', '123', '19-APR-22','Ahmad', 'Ali', 1, 20, 'M');
INSERT INTO UserTable VALUES('AliUser', '111', '10-APR-22', 'Ali', 'Khaled', 2, 22, 'M');
INSERT INTO UserTable VALUES('SaraUser', '222', '3-APR-22', 'Sara', 'Mohammed', 3, 25, 'F');
INSERT INTO UserTable VALUES('HudaUser', '333', '11-APR-22', 'Huda', 'Ahmad', 2, 24, 'F');
INSERT INTO UserTable VALUES('SalemUser', '444', '5-MAR-22', 'Salem', 'Rashid', 3, 24, 'M');
INSERT INTO UserTable VALUES('KhaledUser', '555', '13-JAN-22', 'Khaled', 'Yaser', 3, 23, 'M');
INSERT INTO UserTable VALUES('OmarUser', '666', '2-APR-22', 'Omar', 'Saeed', 3, 23, 'M');
INSERT INTO UserTable VALUES('NoraUser', '777', '11-APR-22', 'Nora', 'Ali', 3, 21, 'F');
INSERT INTO UserTable VALUES('AnasUser', '888', '12-APR-22', 'Anas', 'Ahmad', 2, 30, 'M');
INSERT INTO UserTable VALUES('WaleedUser', '999', '13-APR-22', 'Waleed', 'Khaled', 2, 29, 'M');
INSERT INTO UserTable VALUES('NaserUser', '1010', '14-APR-22', 'Naser', 'Hamad', 2, 33, 'M');


-- inserting patient conditions into patient table with format: Pat_ID, Pat_Condition, UserName;
INSERT INTO PATIENT VALUES(1, 'Sick', 'SaraUser');
INSERT INTO PATIENT VALUES(2, 'Sick', 'SalemUser');
INSERT INTO PATIENT VALUES(3, 'Good', 'KhaledUser');
INSERT INTO PATIENT VALUES(4, 'Good', 'OmarUser');
INSERT INTO PATIENT VALUES(5, 'Good', 'NoraUser');

---
-- inserting doctors into doctors table with format (ID, BIODATA, PositionID, SpecialtyID, UserName) -- 
INSERT INTO DOCTOR VALUES(1, 'BIODATA1', 2, 3, 'AliUser');
INSERT INTO DOCTOR VALUES(2, 'BIODATA2', 4, 2, 'HudaUser');
INSERT INTO DOCTOR VALUES(3, 'BIODATA3', 1, 1, 'AnasUser');
INSERT INTO DOCTOR VALUES(4, 'BIODATA4', 3, 1, 'WaleedUser');
INSERT INTO DOCTOR VALUES(5, 'BIODATA5', 5, 2, 'NaserUser');


--- inserting into Patient Medicine table with format: Start_Date, End_Date, Pat_ID, Med_ID 
INSERT INTO PATIENT_MEDICINE VALUES('1-APR-22', '10-APR-22', 1, 1);
INSERT INTO PATIENT_MEDICINE VALUES('2-APR-22', '14-APR-22', 2, 2);
INSERT INTO PATIENT_MEDICINE VALUES('3-APR-22', '6-APR-22', 3, 3);
INSERT INTO PATIENT_MEDICINE VALUES('4-APR-22', '10-APR-22', 4, 4);
INSERT INTO PATIENT_MEDICINE VALUES('5-APR-22', '9-APR-22', 5, 5);


-- inserting into topic table with format T_ID number(10) PRIMARY KEY, Date_Created DATE,  Approved varchar2(20), Title varchar2(20), Spec_ID, TOPIC_Type_ID, UserName 

INSERT INTO TOPIC VALUES(1, '1-APR-22', 'APPROVED', 'QUESTION 1', 1, 1, 'OmarUser');
INSERT INTO TOPIC VALUES(2, '2-APR-22', 'REJECTED', 'QUESTION 2', 2, 1, 'KhaledUser');
INSERT INTO TOPIC VALUES(3, '3-APR-22', 'REJECTED', 'QUESTION 3', 3, 1, 'SalemUser');
INSERT INTO TOPIC VALUES(4, '4-APR-22', 'APPROVED', 'OMAR OPINION', 2, 5, 'OmarUser');
INSERT INTO TOPIC VALUES(5, '5-APR-22', 'APPROVED', 'GENERAL DISCUSSION', 3, 2, 'AliUser');

--- inserting into Reply table with the format: Rep_ID), Reply , Reply_Date, Topic_ID, UserName;
INSERT INTO REPLY VALUES(1, 'GOOD QUESTION', '2-APR-22', 1, 'KhaledUser');
INSERT INTO REPLY VALUES(2, 'NICE QUESTION', '2-APR-22', 1, 'HudaUser');
INSERT INTO REPLY VALUES(3, 'I AGREE', '3-APR-22', 4, 'SalemUser');
INSERT INTO REPLY VALUES(4, 'I DISAGREE', '4-APR-22', 4, 'WaleedUser');
INSERT INTO REPLY VALUES(5, 'THANK YOU', '5-APR-22', 5, 'NaserUser');


--- inserting into Rating with format Rat_ID, Rat_Date, Rat_Rating, Rat_Comment, Pat_ID , Doc_ID 

INSERT INTO RATING VALUES(1,'8-APR-22', 4, 'Good', 1, 1);
INSERT INTO RATING VALUES(2,'15-APR-22', 5, 'Excellent', 1, 2);
INSERT INTO RATING VALUES(3,'20-APR-22', 4, 'Good', 2, 1);
INSERT INTO RATING VALUES(4,'21-APR-22', 3, 'Normal', 4, 4);
INSERT INTO RATING VALUES(5,'3-APR-22', 3, 'Average', 5, 3);
INSERT INTO RATING VALUES(6,'22-APR-22', 5, 'Excellent', 5, 5);



