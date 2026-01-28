/* Write your T-SQL query statement below */
Select Department, Employee, Salary from (
Select d.name as Department, e.name as Employee, e.salary as Salary, dense_rank() over (partition by e.departmentId order by e.salary desc) as emp_rankings from Employee e Left Join Department d 
on e.departmentId = d.id
)t where t.emp_rankings = 1

 