select 
round(
    st.lat_n
, 4)
from station st
where(
    (select count(lat_n) from station where lat_n < st.lat_n)
    =(select count(lat_n) from station where lat_n > st.lat_n)
)