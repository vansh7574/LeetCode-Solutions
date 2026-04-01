/* Write your T-SQL query statement below */

with cte1 as (
    Select c.name, o.customer_id ,o.order_id, o.order_date, Row_number() over (partition by o.customer_id order by o.order_date desc) as most_recent from Orders o Left Join Customers c on o.customer_id = c.customer_id
)

select name as customer_name, customer_id, order_id, order_date from cte1 where most_recent = 1 or most_recent = 2 or most_recent = 3 order by name, customer_id, order_date desc 
