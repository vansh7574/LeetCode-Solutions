/* Write your T-SQL query statement below */
with weight_totals as (
    Select person_name, weight, Sum(weight) over (order by turn) as total_till_now, turn from Queue
)

Select TOP 1 person_name from weight_totals where total_till_now <= 1000 order by turn desc