/* Write your T-SQL query statement below */
with CTE as (
    Select p.project_id, p.employee_id, e.experience_years, Max(e.experience_years) over (partition by project_id) as max_exp from Project p Left Join Employee e on p.employee_id = e.employee_id
)

Select project_id,employee_id from CTE where experience_years = max_exp