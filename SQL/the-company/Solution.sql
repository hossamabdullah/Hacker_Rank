select 
c.company_code, 
c.founder, 
count(l.lead_manager_code), 
count(s.senior_manager_code),
count(m.manager_code),
count(e.employee_code)
from 
company c, lead_manager l, senior_manager s, manager m, employee e
where
c.company_code = l.company_code and
l.lead_manager_code = s.lead_manager_code and
s.senior_manager_code = m.senior_manager_code and
m.manager_code = e.manager_code
order by c.company_code