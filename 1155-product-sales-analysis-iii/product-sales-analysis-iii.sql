# Write your MySQL query statement below
with initial_years as (
    Select sale_id, product_id, MIN(year) over (partition by product_id) as first_year , year, quantity, price from Sales
)

select product_id, first_year, quantity, price from initial_years where first_year = year