/* Write your T-SQL query statement below */

with totals as (
    Select visited_on, Sum(amount) as date_totals from Customer group by visited_on 
), 
Seven_day_totals as (
    Select *, sum(date_totals * 1.0) over (order by visited_on Rows Between 6 Preceding and current row) as sum_last_7_days,  Row_number() over (order by visited_on) as rn from totals 
)

select visited_on, sum_last_7_days as amount, Round(sum_last_7_days / 7, 2) as average_amount from Seven_day_totals where rn >= 7