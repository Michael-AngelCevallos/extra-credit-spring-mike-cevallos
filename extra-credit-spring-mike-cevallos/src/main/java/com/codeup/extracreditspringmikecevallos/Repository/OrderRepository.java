package com.codeup.extracreditspringmikecevallos.Repository;

import com.codeup.extracreditspringmikecevallos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);

    Order getOrderById(Long id);



}
