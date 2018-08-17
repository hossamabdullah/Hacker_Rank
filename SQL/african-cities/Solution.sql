select ci.name
from city ci, country co
where ci.countrycode = co.code and co.continent='Africa'