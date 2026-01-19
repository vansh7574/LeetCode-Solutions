/* Write your T-SQL query statement below */

With lat_lon_counts as (
    Select *, Count(*) over (partition by lat,lon) as unique_counts, Count(*) Over (partition by tiv_2015) as tiv_2015_cnts   from Insurance 
)
Select Round(Sum(tiv_2016 * 1.0),2) as tiv_2016 from lat_lon_counts where unique_counts = 1 and tiv_2015_cnts > 1 