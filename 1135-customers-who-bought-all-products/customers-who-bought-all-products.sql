/* Write your T-SQL query statement below */
Declare @total INT;
Select @total = Count(*) from Product;

with products_per_cust as (select customer_id, count(distinct product_key) as num_products from Customer group by customer_id)

Select customer_id from products_per_cust where num_products = @total