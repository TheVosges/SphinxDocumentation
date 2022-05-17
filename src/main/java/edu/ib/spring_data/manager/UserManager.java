package edu.ib.spring_data.manager;

import edu.ib.spring_data.dao.UserRepo;
import edu.ib.spring_data.dao.entity.User;
import edu.ib.spring_data.dao.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class UserManager {

    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserDTO find(String name){
        Iterable<UserDTO> list = userRepo.findAll();
        for(UserDTO u: list) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public Iterable<UserDTO> findAll(){
        return userRepo.findAll();
    }

    public UserDTO save(UserDTO user){
        return userRepo.save(user);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
//        UserDTO userDTO = new UserDTO(new User("user", "user123", "CUSTOMER"), passwordEncoder);
//        save(userDTO);
//        save(new UserDTO(new User("admin", "admin123", "ADMIN"), passwordEncoder));


        Connection con= null;
        try {
            con = DriverManager.getConnection("jdbc:h2:file:./spring_data","","");
            PreparedStatement stmt = con.prepareStatement("SELECT u.name, u.password_hash, 1 FROM users u  WHERE u.name='admin'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + passwordEncoder.matches("admin123", rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

