package ChessSpring.utils;


import ChessSpring.model.DataBase.Role;
import ChessSpring.model.DataBase.UserDB;
import ChessSpring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataBaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    private void createUsers() {
        UserDB u1 = new UserDB(1, "user1", passwordEncoder.encode("user1"), "user1@ch.pl", Role.USER);
        UserDB u2 = new UserDB(2, "user2", passwordEncoder.encode("user2"), "user2@ch.pl", Role.USER);
        UserDB u3 = new UserDB(3, "user3", passwordEncoder.encode("user3"), "user3@ch.pl", Role.USER);



        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
    }
}
