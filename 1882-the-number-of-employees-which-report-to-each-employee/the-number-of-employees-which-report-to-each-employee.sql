/* Write your T-SQL query statement below */

with managers as (
    Select reports_to as employee_id, Count(*) as reports_count, Round(AVG(age * 1.0),0) as average_age from Employees where reports_to is not null group by reports_to 
)

Select m.employee_id, e.name, m.reports_count, m.average_age from managers m Inner Join Employees e on m.employee_id = e.employee_id
