package uz.library.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.library.dto.ResponseDto;
import uz.library.dto.UsersDto;
import uz.library.service.Impl.UsersServiceImpl;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UsersResources {

    private final UsersServiceImpl usersService;

    @GetMapping
    public ResponseDto<List<UsersDto>> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping
    public ResponseDto<UsersDto> addUsers(@RequestBody @Valid UsersDto dto){
        return usersService.addUser(dto);
    }

    @PatchMapping
    public ResponseDto<UsersDto> updateUser(@RequestBody UsersDto dto){
        return usersService.updateUser(dto);
    }

    @DeleteMapping
    public ResponseDto<Void> deleteUserById(@RequestParam Integer id){
        return usersService.deleteUserById(id);
    }

    @GetMapping("by-email")
    public ResponseDto<UsersDto> getUserByEmail(@RequestParam String email){
        return usersService.getUserByEmail(email);
    }

}
