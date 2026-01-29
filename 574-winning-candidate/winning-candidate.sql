# Write your MySQL query statement below
with cte as (
Select candidateId, count(*) as cnt, c.name from Vote v Left Join Candidate c on v.candidateId = c.id group by v.candidateId
)

select name from cte order by cnt desc 
limit 1