/* Write your T-SQL query statement below */
with single_numbers as (
 select num from MyNumbers group by num having Count(*) = 1
)

select Max(num) as num from single_numbers

