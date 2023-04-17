do '
begin
    insert into users(id, email, gender, is_active, name, passport_id, phone_number, role, sure_name)
    VALUES(21474836, ''test_a91507627adc'', ''test_a91507627adc'', 1, ''test_a91507627adc'', ''test_a91507627adc'', ''test_a91507627adc'', ''test_a91507627adc'', ''test_a91507627adc'');
end;
' language plpgsql;