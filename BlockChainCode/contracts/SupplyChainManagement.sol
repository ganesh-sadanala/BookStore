// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "./ProductAuthenticity.sol";

contract SupplyChainManagement {
    enum ProductStatus {
        Manufactured,
        Shipped,
        Received,
        Sold
    }

    struct Product {
        address manufacturer;
        string name;
        uint256 price;
        ProductStatus status;
        bool isAuthentic;
    }

    mapping(uint256 => Product) public products;
    uint256 public productIndex=100;

    ProductAuthenticity public productAuthenticity;

    constructor(address _productAuthenticityAddress) {
        productAuthenticity = ProductAuthenticity(_productAuthenticityAddress);
    }

    event ProductManufactured(uint256 indexed productId, address indexed manufacturer);
    event ProductShipped(uint256 indexed productId, address indexed manufacturer);
    event ProductReceived(uint256 indexed productId, address indexed receiver);
    event ProductSold(uint256 indexed productId, address indexed seller, address indexed buyer);
    event ProductMarkedNotAuthentic(uint256 indexed productId, address indexed manufacturer);

    function manufactureProduct(string memory _name, uint256 _price) public returns (uint256) {
        require(_price > 0, "Price must be greater than 0");
        uint256 productId = productIndex++;
        products[productId] = Product(msg.sender, _name, _price, ProductStatus.Manufactured, false);
        emit ProductManufactured(productId, msg.sender);
        return productId;
    }

    function shipProduct(uint256 _productId) public {
        Product storage product = products[_productId];
        require(product.status == ProductStatus.Manufactured, "Product has not been manufactured yet");
        require(product.manufacturer == msg.sender, "Only manufacturer can ship the product");
        product.status = ProductStatus.Shipped;
        emit ProductShipped(_productId, msg.sender);
    }

    function receiveProduct(uint256 _productId) public {
        Product storage product = products[_productId];
        require(product.status == ProductStatus.Shipped, "Product has not been shipped yet");
        product.status = ProductStatus.Received;
        emit ProductReceived(_productId, msg.sender);
    }

    function sellProduct(uint256 _productId) public {
        Product storage product = products[_productId];
        require(product.status == ProductStatus.Received, "Product has not been received yet");
        require(product.isAuthentic == true, "Product is not authentic");
        product.status = ProductStatus.Sold;
        emit ProductSold(_productId, product.manufacturer, msg.sender);
    }

    function markProductAsAuthentic(uint256 _productId) public {
        Product storage product = products[_productId];
        require(product.manufacturer == msg.sender, "Only manufacturer can mark the product as authentic");
        require(product.status != ProductStatus.Sold, "Product has already been sold");
        product.isAuthentic = true;
        productAuthenticity.markProductAsAuthentic(_productId);
    }

    function markProductAsNotAuthentic(uint256 _productId) public {
        Product storage product = products[_productId];
        require(product.manufacturer == msg.sender, "Only manufacturer can mark the product as not authentic");
        require(product.status != ProductStatus.Sold, "Product has already been sold");
        product.isAuthentic = false;
        productAuthenticity.markProductAsNotAuthentic(_productId);
        emit ProductMarkedNotAuthentic(_productId, msg.sender);
    }

    function isProductMarkedAsAuthentic(uint256 _productId) public view returns (bool) {
        return productAuthenticity.isProductMarkedAsAuthentic(_productId);
    }
}