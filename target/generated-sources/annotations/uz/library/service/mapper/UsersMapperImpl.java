package uz.library.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.library.dto.UsersDto;
import uz.library.model.Users;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T14:46:34+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users e) {
        if ( e == null ) {
            return null;
        }

        UsersDto.UsersDtoBuilder usersDto = UsersDto.builder();

        usersDto.name( e.getName() );
        usersDto.sureName( e.getSureName() );
        usersDto.gender( e.getGender() );
        usersDto.passportId( e.getPassportId() );
        usersDto.phoneNumber( e.getPhoneNumber() );
        usersDto.email( e.getEmail() );
        usersDto.role( e.getRole() );
        if ( e.getIsActive() != null ) {
            usersDto.isActive( e.getIsActive().shortValue() );
        }

        return usersDto.build();
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
