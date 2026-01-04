/* Write your T-SQL query statement below */

with all_combs as (
    select * from Students Cross Join Subjects
),
num_attended as (
    select student_id, subject_name, count(*) as attended_exams from Examinations group by student_id, subject_name 
)

Select allc.student_id, allc.student_name, allc.subject_name, isnull(na.attended_exams, 0) as attended_exams  from all_combs allc Left Join num_attended na on allc.student_id = na.student_id and allc.subject_name = na.subject_name order by student_id, subject_name
