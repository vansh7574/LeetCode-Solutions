# Write your MySQL query statement below

Select t.student_id, t.course_id, t.grade from (
    Select student_id, course_id, grade, Dense_rank() over (partition by student_id order by grade desc, course_id ASC) as rnk from Enrollments
)t where rnk = 1
