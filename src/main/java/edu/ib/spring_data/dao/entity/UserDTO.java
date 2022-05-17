package edu.ib.spring_data.dao.entity;

//import edu.ib.spring_data.PasswordEncoderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserDTO {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long user_id;

    private String name;
    private String passwordHash;
    private String role;

    public UserDTO() {
    }

    public UserDTO(User user,PasswordEncoder passwordEncoder) {
        this.name = user.getName();
        this.passwordHash = passwordEncoder.encode(user.getPassword());
        this.role = user.getRole();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return user_id.equals(userDTO.user_id) && name.equals(userDTO.name) && passwordHash.equals(userDTO.passwordHash) && role.equals(userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name, passwordHash, role);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserDTO user = (UserDTO) o;
//        return Objects.equals(user_id, user.user_id) && Objects.equals(name, user.name) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(role, user.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(user_id, name, passwordHash, role);
//    }
//
//    public void updateClass(UserDTO user){
//        if (user.getName() != null) {
//            this.name = user.getName();
//        }
//        if (user.getPassword() != null) {
//            this.passwordHash = user.getPassword();
//        }
//        if (user.getRole() != null) {
//            this.role = user.getRole();
//        }
//    }
}
