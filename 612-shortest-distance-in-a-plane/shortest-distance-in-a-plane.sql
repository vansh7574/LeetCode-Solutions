
with numbered as (
   Select x, y, Row_Number() over (order by (select null)) as rn from Point2D
),

dist as ( 
Select n1.x as x1, n1.y as y1, n2.x as x2, n2.y as y2, Round(sqrt(power(n2.x-n1.x ,2) + power(n2.y-n1.y,2)),2) as distance   
from numbered n1 Inner join numbered n2 on n1.rn < n2.rn
)

Select Min(distance) as shortest from dist