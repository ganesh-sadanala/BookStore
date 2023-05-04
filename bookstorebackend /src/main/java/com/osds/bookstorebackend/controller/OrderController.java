package com.osds.bookstorebackend.controller;

import com.osds.bookstorebackend.modal.Book;
import com.osds.bookstorebackend.modal.Orders;
import com.osds.bookstorebackend.modal.OrderRequest;
import com.osds.bookstorebackend.service.BookService;
import com.osds.bookstorebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000,http://44.204.81.117:8080")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    // Endpoint to place a new order
    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            List<Orders> orders = new ArrayList<>();

            for (int i = 0; i < orderRequest.getOrderItems().size(); i++) {
                long bookId = orderRequest.getOrderItems().get(i).getBookId();
                int quantity = orderRequest.getOrderItems().get(i).getQuantity();

                // Check if book exists
                Book book = bookService.getBookById(bookId);
                if (book == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book with id " + bookId + " does not exist");
                }

                // Check if book is in stock
//                if (book.getQuantity() < quantity) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough stock for book with id " + bookId);
//                }

                // Create order
                Orders order = new Orders();
                order.setBookid(bookId);
                order.setCustomername(orderRequest.getOrderItems().get(i).getCustomerName());
                order.setQuantity(quantity);
                order.setTotalprice(book.getPrice() * quantity);

                // Place order
                Orders placedOrders = orderService.placeOrder(order);
                orders.add(placedOrders);

                // Update book quantity
//                book.setQuantity(book.getQuantity() - quantity);
//                bookService.updateBook(book.getId(), book);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint to get order details by order id
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        try {
            Orders orders = orderService.getOrderById(orderId);
            if (orders == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


