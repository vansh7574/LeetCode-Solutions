/* Write your T-SQL query statement below */

with gt_100 as (
    select product_id , Sum(unit) as unit from Orders where Year(order_date) = '2020' and Month(order_date) = '2' group by product_id having Sum(unit) >= 100
)

Select product_name, unit from gt_100 g Left Join Products p on g.product_id = p.product_id