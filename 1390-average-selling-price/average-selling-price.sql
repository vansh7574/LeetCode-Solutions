/* Write your T-SQL query statement below */
-- with totals as (
--     select p.product_id, (p.price * Nullif(u.units, 0)) as total_amount, Sum(NullIf(units,0)) over (partition by p.product_id) as total_units from Prices p Left Join UnitsSold u on p.product_id = u.product_id where u.purchase_date BETWEEN start_date and end_date
-- ),
-- product_totals as (
--      select distinct product_id, sum(total_amount) over (partition by product_id) as total_per_product, total_units from totals
-- )

-- Select product_id, ROUND(total_per_product * 1.0/total_units,2) as average_price from product_totals
-- Select product_id, Sum(total_amount * 1.0) OVER (partition by product_id)/ Sum(total_units) over (partition by product_id)  as average_price  from totals

SELECT
    p.product_id,
    ISNULL(
        ROUND(
            SUM(p.price * u.units * 1.0) / NULLIF(SUM(u.units), 0),
            2
        ),
        0
    ) AS average_price
FROM Prices AS p
LEFT JOIN UnitsSold AS u
    ON p.product_id = u.product_id
   AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY
    p.product_id;

