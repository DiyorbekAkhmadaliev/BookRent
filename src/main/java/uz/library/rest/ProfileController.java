package uz.library.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.library.dto.UserDto;
import uz.library.model.Users;

@RestController
@RequestMapping("/api")
public class ProfileController {

//    private UserRepository userRepository;
//
//    public ProfileController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @GetMapping("/profile")
//    @Secured("ROLE_USER")
//    public UserDto getProfile(@AuthenticationPrincipal UserDetails userDetails) {
//        User user = userRepository.findByEmail(userDetails.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        // Map User entity to UserDTO for returning to client
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setFirstName(user.getFirstName());
//        userDTO.setLastName(user.getLastName());

//        return userDTO;
//    }

    // Other endpoints
}

