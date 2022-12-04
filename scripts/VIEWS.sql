CREATE VIEW PERSONAL_DATA (NAME, AGE, GENDER)

AS SELECT (FNAME || ' ' || LNAME), age, GENDER FROM USERTABLE;





--SELECT STATEMENT TO VALIDATE THE WORK OF THE VIEW VIEW BEST_RATED_DOCTOR BEFORE CREATING IT;
SELECT
    d.doc_id          AS DOCTOR_ID,
    (e.FNAME || ' ' || e.LNAME) as DOCTOR_NAME,
    COUNT(d.rat_id)   AS "RATING_NO",
    AVG(d.rat_rating) AS "AVG_RATING"
    
FROM
    rating    d,
    doctor    c,
    usertable e
WHERE
        c.doc_id = d.doc_id
    AND e.username = c.username
    AND EXTRACT(YEAR FROM d.rat_date) > 2020
GROUP BY
    d.doc_id,
    e.fname,
    e.lname Order By "AVG_RATING" Desc;

--(FNAME || ' ' || LNAME) ,

--VIEW CREATION
CREATE OR REPLACE VIEW BEST_RATED_DOCTOR (DOCTOR_ID,DOCTOR_NAME, RATING_NO, AVG_RATING)
AS SELECT
    d.doc_id          AS DOCTOR_ID,
    (e.FNAME || ' ' || e.LNAME) as DOCTOR_NAME,
    COUNT(d.rat_id)   AS "RATING_NO",
    AVG(d.rat_rating) AS "AVG_RATING"
    
FROM
    rating    d,
    doctor    c,
    usertable e
WHERE
        c.doc_id = d.doc_id
    AND e.username = c.username
    AND EXTRACT(YEAR FROM d.rat_date) > 2020
GROUP BY
    d.doc_id,
    e.fname,
    e.lname Order By "AVG_RATING" Desc;
    

SELECT * FROM BEST_RATED_DOCTOR;

--------
CREATE VIEW PERSONAL_DATA (NAME, AGE, GENDER)

AS SELECT (FNAME || ' ' || LNAME), age, GENDER FROM USERTABLE;   --VIEW FOR PERSONAL DATA VIEW FOR ALL USERS

SELECT * FROM PERSONAL_DATA;
-----

CREATE VIEW PERSONAL_D_DATA (NAME, AGE, GENDER)

AS SELECT (FNAME || ' ' || LNAME), age, GENDER FROM USERTABLE
WHERE USERTYPE_ID = 2;   --VIEW FOR PERSONAL DATA VIEW FOR DOCTOR USERS

SELECT * FROM PERSONAL_D_DATA;

--------;
CREATE VIEW PERSONAL_P_DATA (NAME, AGE, GENDER)

AS SELECT (FNAME || ' ' || LNAME), age, GENDER FROM USERTABLE
WHERE USERTYPE_ID = 3;   --VIEW FOR PERSONAL DATA VIEW FOR DOCTOR USERS

SELECT * FROM PERSONAL_P_DATA;





