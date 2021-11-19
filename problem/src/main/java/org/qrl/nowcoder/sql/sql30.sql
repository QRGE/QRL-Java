-- https://www.nowcoder.com/practice/2f2e556d335d469f96b91b212c4c203e?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
-- 子查询：嵌套在其他查询中的查询
select f.title,f.description from film as f
where f.film_id in (
    select fc.film_id from film_category as fc
    where fc.category_id in (
        select c.category_id from category as c
        where c.name = 'Action'
));