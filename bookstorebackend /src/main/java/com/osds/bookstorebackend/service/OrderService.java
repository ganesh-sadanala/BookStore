package com.osds.bookstorebackend.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.osds.bookstorebackend.modal.Book;
import com.osds.bookstorebackend.modal.Orders;
import com.osds.bookstorebackend.other.BadRequestException;
import com.osds.bookstorebackend.other.ResourceNotFoundException;
import com.osds.bookstorebackend.other.SupplyChainManagement;
import com.osds.bookstorebackend.repository.BookRepository;
import com.osds.bookstorebackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.swing.plaf.synth.Region;
import java.math.BigInteger;
import java.util.List;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    AmazonSNS snsClient;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SmartContractService smartContractService;

    public Orders placeOrder(Orders orders) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIA34YF7XNSVJAERLLK", "SN6cM+P3gxFjwQTuaT+4lzL7cvCui187294GrLq8");
        snsClient = AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.US_EAST_1)
                .build();
        // check if book exists
        Book book = bookRepository.findById(orders.getBookid())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + orders.getBookid()));

        // check book quantity
        // if (book.getQuantity() < order.getQuantity()) {
        //     throw new BadRequestException("Not enough stock for book with id " + order.getBookId());
        // }

        // make payment using PayPal
        // payPalService.makePayment(order.getTotalPrice());

        // update supply chain smart contract
        boolean isAuthentic = smartContractService.isProductAuthentic(BigInteger.valueOf(book.getId()));
        if (isAuthentic) {
            // supplyChain.markProductAsAuthentic(orderRequest.getSerialNumber(), "SOLD");
            // create order
            bookRepository.save(book);

            // publish message to SNS topic
            String message = "A new order has been placed with order id " + orders.getId();
            String topicArn = "arn:aws:sns:us-east-1:817666964325:orderrecord"; // replace with your SNS topic ARN
            PublishRequest publishRequest = new PublishRequest(topicArn, message);
            snsClient.publish(publishRequest);
        } else {
            // supplyChain.updateProductStatus(orderRequest.getSerialNumber(), "FAKE");
            throw new BadRequestException("Product is not authentic");
        }

        return orderRepository.save(orders);
    }


    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }
}
