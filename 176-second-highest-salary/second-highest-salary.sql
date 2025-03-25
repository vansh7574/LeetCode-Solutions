/* Write your T-SQL query statement below */
SELECT 
    (SELECT DISTINCT Salary 
     FROM Employee 
     ORDER BY Salary DESC 
     OFFSET 1 ROW FETCH NEXT 1 ROW ONLY) AS SecondHighestSalary;