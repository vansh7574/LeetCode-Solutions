/* Write your T-SQL query statement below */

Select score, Dense_Rank() over (order by score desc) as rank from Scores order by score desc