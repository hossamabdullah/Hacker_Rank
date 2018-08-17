select
h.hacker_id, h.name
from 
hackers h, submissions s
where
h.hacker_id = s.hacker_id and

select count(*)
from submissions s, challenges ch, difficulty d
where s.challenge_id = ch.challenge_id
and ch.difficulty_level = d.difficulty_level
and s.score = d.score


select s.hacker_id, h.name
from submissions s, challenges ch, difficulty d, hackers h
where s.challenge_id = ch.challenge_id
and ch.difficulty_level = d.difficulty_level
and s.score = d.score
and s.hacker_id = h.hacker_id
group by s.hacker_id
order by count(s.hacker_id) desc, s.hacker_id asc 


select  h.hacker_id, h.name 
from hackers h, submissions s, challenges ch, difficulty d
where s.hacker_id = h.hacker_id
and s.challenge_id = ch.challenge_id
and ch.difficulty_level = d.difficulty_level
and s.score = d.score
group by h.name, h.hacker_id
having count(h.hacker_id) > 1
order by count(h.hacker_id) desc, h.hacker_id asc


select count(*), h.hacker_id 
from hackers h, submissions ss, challenges chh, difficulty dd
where ss.hacker_id = h.hacker_id
and ss.challenge_id = chh.challenge_id
and chh.difficulty_level = dd.difficulty_level
and ss.score = dd.score
group by h.hacker_id
having count(*)