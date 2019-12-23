insert into users
(username, password, isAdmin)
select 'admin', 'admin', true
where not exists (
        select username from users where username = 'admin'
    );