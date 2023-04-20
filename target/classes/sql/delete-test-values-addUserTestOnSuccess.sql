do '
begin
if exists(select * from users where email = ''testOnSuccess@gmail.com'') then
    delete from users where email = ''testOnSuccess@gmail.com'';
    end if;
end;
'