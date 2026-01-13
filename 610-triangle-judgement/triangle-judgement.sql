/* Write your T-SQL query statement below */
Select x, y, z, (case when x + y > z and x + z > y and y + z > x THEN 'Yes' ELSE 'No' END) as triangle from Triangle 