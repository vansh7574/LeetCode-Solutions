/* Write your T-SQL query statement below */
with before_date_prices as (
    Select  distinct product_id, First_Value(new_price) over (partition by product_id order by change_date desc) as price from Products where change_date <= '2019-08-16'
),
after_date_prices as (
    Select product_id, 10 as price from Products where change_date > '2019-08-16' and product_id not in (select product_id from before_date_prices)
)

SELECT product_id, price FROM before_date_prices
UNION
SELECT product_id, price FROM after_date_prices;
