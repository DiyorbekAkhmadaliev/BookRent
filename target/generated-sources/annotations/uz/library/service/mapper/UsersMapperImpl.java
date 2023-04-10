package uz.library.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.library.dto.UsersDto;
import uz.library.model.Users;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-07T17:00:23+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users e) {
        if ( e == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        usersDto.setId( e.getId() );
        usersDto.setName( e.getName() );
        usersDto.setSureName( e.getSureName() );
        usersDto.setGender( e.getGender() );
        usersDto.setPassportId( e.getPassportId() );
        usersDto.setPhoneNumber( e.getPhoneNumber() );
        usersDto.setEmail( e.getEmail() );
        usersDto.setRole( e.getRole() );
        if ( e.getIsActive() != null ) {
            usersDto.setIsActive( e.getIsActive().shortValue() );
        }

        return usersDto;
    }

    @Override
    public Users toEntity(UsersDto d) {
        if ( d == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( d.getId() );
        users.setName( d.getName() );
        users.setSureName( d.getSureName() );
        users.setGender( d.getGender() );
        users.setPassportId( d.getPassportId() );
        users.setPhoneNumber( d.getPhoneNumber() );
        users.setEmail( d.getEmail() );
        users.setRole( d.getRole() );
        users.setIsActive( (int) d.getIsActive() );

        return users;
    }
}
