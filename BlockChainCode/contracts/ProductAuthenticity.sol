// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ProductAuthenticity {
    mapping (uint256 => bool) public isProductAuthentic;

    function markProductAsAuthentic(uint256 productId) public {
        isProductAuthentic[productId] = true;
    }

    function markProductAsNotAuthentic(uint256 productId) public {
        isProductAuthentic[productId] = false;
    }
    
    function isProductMarkedAsAuthentic(uint256 productId) public view returns (bool) {
        return isProductAuthentic[productId];
    }
}
