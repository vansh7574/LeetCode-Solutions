/* Write your T-SQL query statement below */
with all_one_userid as (
    Select user1_id, user2_id from Friendship where user1_id = 1
    Union All
    Select user2_id, user1_id from Friendship where user2_id = 1
)

Select distinct page_id as recommended_page from all_one_userid al Inner Join Likes l on al.user2_id = l.user_id where page_id not in (Select page_id from Likes where user_id = 1)
