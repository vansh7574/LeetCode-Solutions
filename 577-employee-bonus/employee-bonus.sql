/* Write your T-SQL query statement below */

Select e.name, b.bonus from Employee e Left Join Bonus b on e.empId = b.empId where bonus is null or bonus < 1000