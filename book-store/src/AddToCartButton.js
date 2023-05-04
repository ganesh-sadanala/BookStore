import React, { useState } from "react";
import { Link } from 'react-router-dom';

const AddToCartButton = ({ book, handleAddToCart }) => {
  const [isAdded, setIsAdded] = useState(false);

  // const handleAddToCart = () => {
  //   handleAddToCart()
  //   setIsAdded(true);
  // };

  return (
    <>
      <button
        onClick={() => handleAddToCart(book, 1)}
        className="bg-blue-500 text-white px-4 py-2 rounded-full font-semibold transition duration-500 ease-in-out hover:bg-blue-700 transform hover:-translate-y-1 hover:scale-110 mt-4"
      >
        Add to Cart
      </button>
    </>
  );
};

export default AddToCartButton;
