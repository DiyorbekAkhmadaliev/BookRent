package uz.library.service.mapper;

import org.mapstruct.Mapper;
import uz.library.dto.UsersDto;
import uz.library.model.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper extends CommonMapper<UsersDto, Users>{
}
