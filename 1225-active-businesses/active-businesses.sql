# Write your MySQL query statement below
with avg_occurence as (
    Select event_type, Sum(occurrences) * 1.0/Count(distinct business_id) as avg_occur from Events group by event_type
)

Select e.business_id from Events e Left Join avg_occurence a on e.event_type = a.event_type where e.occurrences > a.avg_occur group by e.business_id Having Count(*) > 1

