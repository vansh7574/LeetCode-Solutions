/* Write your T-SQL query statement below */
with first_orders_per_customer as (
    select delivery_id, customer_id, order_date, min(order_date) OVER (partition by customer_id) as first_orders, customer_pref_delivery_date from Delivery  
)

select Round(100.0 * Count(case when first_orders = customer_pref_delivery_date THEN 1 ELSE null END)/COUNT(DISTINCT customer_id),2) as immediate_percentage from first_orders_per_customer 

