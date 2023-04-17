do '
begin
    insert into users(id, email, name, phone_number, role, sure_name, is_active)
    VALUES(2147483647, ''deleteValue@gmail.com'', ''DeleteValue'', ''BB9876454'', ''USER'', ''ValueDelete'', 1);
end;
' language plpgsql;