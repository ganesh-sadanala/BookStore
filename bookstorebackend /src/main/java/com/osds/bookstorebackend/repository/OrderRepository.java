package com.osds.bookstorebackend.repository;

import com.osds.bookstorebackend.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    // custom methods for querying orders
}

