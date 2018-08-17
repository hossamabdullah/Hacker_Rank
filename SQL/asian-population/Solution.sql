select sum(ci.population)
from city ci, country co
where co.CONTINENT = 'Asia' and ci.countrycode = co.code