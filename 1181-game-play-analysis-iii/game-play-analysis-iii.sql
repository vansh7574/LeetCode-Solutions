/* Write your T-SQL query statement below */

Select player_id, event_date, Sum(games_played) over (partition by player_id order by event_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) as games_played_so_far from Activity