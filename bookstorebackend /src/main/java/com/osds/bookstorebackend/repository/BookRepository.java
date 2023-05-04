package com.osds.bookstorebackend.repository;

import com.osds.bookstorebackend.modal.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // custom methods for querying books
}

