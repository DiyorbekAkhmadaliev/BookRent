do '
declare
begin
    insert into users(id,email, gender, name, passport_id, phone_number, sure_name, role)
        values(nextval(''user_id_seq''),''testOnFail@gmail.com'', ''MALE'', ''TestOnFail'', ''AA123456789'', ''+998999875463'', ''CaseOnFail'', ''USER'');
end;
' language plpgsql;