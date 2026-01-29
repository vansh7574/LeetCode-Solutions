/* Write your T-SQL query statement below */

with cte as (
    Select question_id as Survey_log, Count(answer_id) * 1.0/Count(case when action = 'show' then 1 else NULL END) as ans_rate from SurveyLog group by question_id 
)

Select Top 1 Survey_log from cte order by ans_rate desc, Survey_log ASC