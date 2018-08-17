select  h.hacker_id, h.name 
from hackers h, submissions s, challenges ch, difficulty d
where s.hacker_id = h.hacker_id
and s.challenge_id = ch.challenge_id
and ch.difficulty_level = d.difficulty_level
and s.score = d.score
group by h.name, h.hacker_id
having count(h.hacker_id) > 1
order by count(h.hacker_id) desc, h.hacker_id asc