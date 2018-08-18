select
con.contest_id,
con.hacker_id,
con.name,
sum(distinct v.total_views),
sum(distinct v.total_unique_views),
sum(distinct s.total_submissions),
sum(distinct s.total_accepted_submissions)
from contests con, colleges col, challenges cha, view_stats v, submission_stats s
where
con.contest_id = col.contest_id and
col.college_id = cha.college_id and
cha.challenge_id = v.challenge_id and
cha.challenge_id = s.challenge_id
group by 
con.contest_id,
con.hacker_id,
con.name
having
sum(distinct v.total_views) <> 0 and
sum(distinct v.total_unique_views) <> 0 and
sum(distinct s.total_submissions) <> 0 and
sum(distinct s.total_accepted_submissions) <> 0
order by con.contest_id