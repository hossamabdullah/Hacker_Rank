select
h.hacker_id, h.name
from 
hackers h, submissions s
where
h.hacker_id = s.hacker_id and
score =

select count(*)
from submissions s, challenges ch, difficulty d
where hacker_id = '1123'
and s.challenge_id = ch.challenge_id
and ch.difficulty_level = d.difficulty_level
and s.score = d.score