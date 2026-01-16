/* Write your T-SQL query statement below */

Select id , case  WHEN id = (SELECT COUNT(*) FROM Seat) and id % 2 <> 0 THEN Student when id % 2 <> 0 THEN Lead(student) over (order by id) when id % 2 = 0 THEN Lag(student) over (order by id) END as student from Seat order by id