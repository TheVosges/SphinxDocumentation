package edu.ib.spring_data.dao;


import edu.ib.spring_data.dao.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
