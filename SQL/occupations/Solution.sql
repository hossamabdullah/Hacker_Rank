SELECT  
  GROUP_CONCAT(if(occupation = 'Doctor', name, NULL)) AS 'Doctor', 
  GROUP_CONCAT(if(occupation = 'Professor', name, NULL)) AS 'Professor', 
  GROUP_CONCAT(if(occupation = 'Singer', name, NULL)) AS 'Singer',
  GROUP_CONCAT(if(occupation = 'Actor', name, NULL)) AS 'Actor' 
FROM occupations