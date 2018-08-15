select salary*months as max_salary, count(name) 
from employee 
group by 1
order by max_salary desc
limit 1
/*
group by 1
1 means the first columns
*/