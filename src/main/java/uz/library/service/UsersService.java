package uz.library.service;

import uz.library.dto.ResponseDto;
import uz.library.dto.UsersDto;

import java.util.List;

public interface UsersService {

    ResponseDto<List<UsersDto>> getAllUsers();
    ResponseDto<UsersDto> getUserByEmail(String email);
    ResponseDto<UsersDto> updateUser(UsersDto dto);
    ResponseDto<UsersDto> addUser(UsersDto dto);
    ResponseDto<Void> deleteUserById(Integer id);
}
