package ChessSpring.model.DTO;


import ChessSpring.model.DataBase.UserDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String role;

    public UserDTO(UserDB userDB){
        this.username = userDB.getUsername();
        this.password = userDB.getPassword();
//        this.email = userDB.getEmail();
        this.role = String.valueOf(userDB.getRole());
    }
}
