package uz.library.service.Impl;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.library.dto.ResponseDto;
import uz.library.dto.UsersDto;
import uz.library.model.Users;
import uz.library.repository.UsersRepository;
import uz.library.service.UsersService;
import uz.library.service.mapper.UsersMapper;

import java.util.List;
import java.util.Optional;

import static uz.library.service.validator.AppStatusCodes.*;
import static uz.library.service.validator.AppStatusMessages.*;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Override
    public ResponseDto<List<UsersDto>> getAllUsers() {
        List<Users> users = usersRepository.findAll();

        if (users.isEmpty()) {
            return ResponseDto.<List<UsersDto>>builder()
                    .message(NOT_FOUND)
                    .code(NOT_FOUND_ERROR_CODE)
                    .build();
        }

        return ResponseDto.<List<UsersDto>>builder()
                .message(OK)
                .code(OK_CODE)
                .data(users.stream().map(usersMapper::toDto).toList())
                .success(true)
                .build();
    }

    @Override
    public ResponseDto<UsersDto> getUserByEmail(String email) {
        return usersRepository.findByEmailAndIsActive(email, (short) 1)
                .map(u ->
                        ResponseDto.<UsersDto>builder()
                                .message(OK)
                                .code(OK_CODE)
                                .data(usersMapper.toDto(u))
                                .success(true)
                                .build()
                ).orElse(
                        ResponseDto.<UsersDto>builder()
                                .message(NOT_FOUND)
                                .code(NOT_FOUND_ERROR_CODE)
                                .build());

    }

    @Override
    public ResponseDto<UsersDto> updateUser(UsersDto dto) {
        if (dto.getId() == null) {
            return ResponseDto.<UsersDto>builder()
                    .message(NULL_VALUE)
                    .code(VALIDATION_ERROR_CODE)
                    .build();
        }

        Optional<Users> optional = usersRepository.findById(dto.getId());

        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .code(NOT_FOUND_ERROR_CODE)
                    .message(NOT_FOUND)
                    .build();
        }

        try {
            Users u = setUserParameters(dto, optional.get());
            usersRepository.save(u);
            return ResponseDto.<UsersDto>builder()
                    .message(OK)
                    .code(OK_CODE)
                    .data(usersMapper.toDto(u))
                    .success(true)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UsersDto>builder()
                    .message(DATABASE_ERROR + " " + e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .build();
        }
    }

    @Override
    public ResponseDto<UsersDto> addUser(UsersDto dto) {
        dto.setIsActive((short) 1);
        Users user = usersRepository.save(usersMapper.toEntity(dto));
        return ResponseDto.<UsersDto>builder()
                .message(OK)
                .code(OK_CODE)
                .success(true)
                .data(usersMapper.toDto(user))
                .build();
    }

    @Override
    public ResponseDto<Void> deleteUserById(Integer id) {

        Optional<Users> optional = usersRepository.findByIdAndIsActive(id, (short) 1);

        if (optional.isEmpty()){
            return ResponseDto.<Void>builder()
                    .code(NOT_FOUND_ERROR_CODE)
                    .message(NOT_FOUND)
                    .build();
        }
        try {
            Users users = optional.get();
            users.setIsActive(0);
            usersRepository.save(users);
            return ResponseDto.<Void>builder()
                    .message(OK)
                    .code(OK_CODE)
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<Void>builder()
                    .message(DATABASE_ERROR + " " + e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .build();
        }
    }

    private Users setUserParameters(UsersDto dto, Users entity) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getSureName() != null) {
            entity.setSureName(dto.getSureName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getGender() != null) {
            entity.setGender(dto.getGender());
        }
        if (dto.getPassportId() != null) {
            entity.setPassportId(dto.getPassportId());
        }
        if (dto.getPhoneNumber() != null) {
            entity.setPhoneNumber(dto.getPhoneNumber());
        }
        return entity;
    }
}
