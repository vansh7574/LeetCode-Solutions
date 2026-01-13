/* Write your T-SQL query statement below */
with num_departments as (
    Select employee_id, count(*) as num_depts from Employee group by employee_id
)

Select e.employee_id, e.department_id from Employee e Left Join num_departments n on e.employee_id = n.employee_id where n.num_depts = 1 or e.primary_flag = 'Y'