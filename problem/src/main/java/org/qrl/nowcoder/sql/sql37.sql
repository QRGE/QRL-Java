-- https://www.nowcoder.com/practice/e1824daa0c49404aa602cf0cb34bdd75?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
CREATE UNIQUE INDEX uniq_idx_firstname ON actor(first_name);
CREATE INDEX idx_lastname ON actor(last_name);