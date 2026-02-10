/* Write your T-SQL query statement below */
with cte1 as (
    Select b.book_id, b.name, b.available_from, o.order_id, o.book_id as order_book_id, o.quantity, o.dispatch_date from Books b LefT Join Orders o on b.book_id = o.book_id where b.available_from < '2019-05-25'
),
cte2 as (
    Select *, Sum(case when dispatch_date >= '2018-06-23' and dispatch_date <= '2019-06-23' Then quantity Else 0 End) over (partition by book_id) as summ from cte1
)

Select distinct book_id, name from cte2 where summ < 10