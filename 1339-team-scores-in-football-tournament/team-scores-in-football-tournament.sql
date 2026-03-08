/* Write your T-SQL query statement below */

with hosts as (
    Select host_team, Sum(case when host_goals > guest_goals Then 3 When host_goals = guest_goals THEN 1 ELSE 0 END) as num_points from Matches group by host_team
),
guests as (
    Select guest_team, Sum(case when guest_goals > host_goals Then 3 When host_goals = guest_goals THEN 1 ELSE 0 END) as num_points from Matches group by guest_team
),
total as (
    Select coalesce(h.host_team, g.guest_team) as team_id, isNull(h.num_points,0) + isNull(g.num_points,0) as total_points from hosts h full outer join guests g on h.host_team = g.guest_team
)

Select  t.team_id as team_id, t.team_name as team_name, isNull(tot.total_points, 0) as num_points from Teams t Left Join total tot on t.team_id = tot.team_id order by isNull(tot.total_points,0) desc, t.team_id ASC


-- Select * from hosts
