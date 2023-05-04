package com.osds.bookstorebackend.service;

import com.osds.bookstorebackend.other.ProductAuthenticity;
import com.osds.bookstorebackend.other.SupplyChainManagement;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.File;
import java.math.BigInteger;

@Service
public class SmartContractService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final String productAuthContractAdress;
    private final ProductAuthenticity productAuth;

    @Autowired
    public SmartContractService(@Value("${web3j.client-address}") String clientAddress,
                                @Value("${contract.productAuthAddress}") String productAuthContractAdress) throws Exception {
        web3j = Web3j.build(new HttpService(clientAddress));
        String privateKey = "130ea162b86bf87ff1ee23fa807b8602063a7b2854e028c16ab08dedab1267b2";
        credentials = Credentials.create(privateKey);
        this.productAuthContractAdress = productAuthContractAdress;
        productAuth = ProductAuthenticity.load(productAuthContractAdress, web3j, credentials, new DefaultGasProvider());
    }

    public boolean isProductAuthentic(BigInteger productCode) {
        try {
            return productAuth.isProductMarkedAsAuthentic(productCode).send();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
