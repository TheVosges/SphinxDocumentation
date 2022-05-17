package edu.ib.spring_data.dao;

import edu.ib.spring_data.dao.entity.User;
import edu.ib.spring_data.dao.entity.UserDTO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserDTO, Long> {
}
