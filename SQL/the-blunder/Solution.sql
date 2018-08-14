select CEILING(avg(salary) - avg((REPLACE(salary,'0',''))))
from employees