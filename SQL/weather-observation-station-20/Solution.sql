select
round(
    lat_n    
, 4)
from station
limit ( 
    select count(*)/2
    from station
    order by lat_n)