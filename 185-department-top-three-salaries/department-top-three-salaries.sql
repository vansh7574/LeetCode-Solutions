# Write your MySQL query statement below
with all_ranks as (
    Select d.name as Department, e.name as Employee, e.salary, DENSE_RANK() over (partition by e.departmentId order by e.salary desc) as ranks from Employee e Left join Department d on e.departmentId = d.id
)
Select Department, Employee, Salary from all_ranks where ranks <= 3