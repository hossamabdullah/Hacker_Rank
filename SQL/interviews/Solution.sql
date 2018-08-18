select
from contests con, colleges col, challenges cha, view_stats v, submission_stats s
where
con.contest_id = col.contest_id and
col.college_id = cha.college_id and
cha.challenge_id = v.challenge_id and
cha.challenge_id = s.challenge_id