/* Write your T-SQL query statement below */
Select name as results from Users  where name in  (Select Top 1 u.name from Users u Left Join MovieRating m on u.user_id = m.user_id group by u.user_id, u.name order by Count(*) desc, u.name)


Union all 

Select title as results from movies  where title in (Select Top 1 m.title from Movies m Left Join MovieRating mr on m.movie_id = mr.movie_id where mr.created_at >= '2020-02-01' and mr.created_at < '2020-03-01' group by m.movie_id, m.title order by Avg(rating * 1.0) desc, m.title asc)


