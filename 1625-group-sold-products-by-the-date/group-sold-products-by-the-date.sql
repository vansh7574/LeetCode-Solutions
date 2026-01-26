/* Write your T-SQL query statement below */
-- Select sell_date, count(*) as num_sold, String_Agg(product,', ') as products from Activities group by sell_date

with unique_combo as (
    Select distinct sell_date, product from Activities
)

Select sell_date, count(*) as num_sold, String_Agg(product,',') within Group (order by product) as products from unique_combo group by sell_date
