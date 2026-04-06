
with cte as (
    select student_id, subject, score, exam_date, Row_Number() over (partition by student_id, subject order by exam_date) as rn from Scores
),
latest_scores as (
    select student_id, subject, score, exam_date, rn, max(rn) over (partition by student_id, subject) as latest from cte  
)

select l1.student_id, l1.subject, l1.score as first_Score, l2.score as latest_score from latest_scores l1 inner join latest_scores l2 on l1.student_id = l2.student_id and l1.subject = l2.subject and l1.rn = 1 and l2.rn = l2.latest and l1.rn < l2.rn where l1.score < l2.score order by l1.student_id, l1.subject