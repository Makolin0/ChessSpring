package ChessSpring.services;

import ChessSpring.model.DTO.UserDTO;
import ChessSpring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllDTO() {
        return userRepository.findAll().stream().map((userData -> {
            return new UserDTO(userData);
        })).toList();
    }
}
