select
round(
    lat_n    
, 4)
from station
limit ( 
    select round(count(*)/2, 0)
    from station
    order by lat_n), 1