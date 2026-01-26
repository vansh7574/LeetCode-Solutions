/* Write your T-SQL query statement below */
select user_id , Concat(Upper(SubString(name,1,1)),Lower(SubString(name,2,len(name)))) as name from Users order by user_id