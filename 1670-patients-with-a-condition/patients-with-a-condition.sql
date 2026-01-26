/* Write your T-SQL query statement below */
--Select patient_id, patient_name, STRING_SPLIT(conditions,' ' ) from Patients

SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%';