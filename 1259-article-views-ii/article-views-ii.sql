/* Write your T-SQL query statement below */

Select distinct viewer_id as id from (
    Select view_date, viewer_id, Count(distinct article_id) as cnt_articles  from Views group by view_date, viewer_id
)t where t.cnt_articles > 1
