import React, { useState } from "react";
import AddToCartButton from "./AddToCartButton";

const BookDetailPage = ({ book, handleAddToCart }) => {
  
  if (!book) {
    return null; // or display an error message
  }

  return (
    <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
      <div className="px-4 py-6 sm:px-0">
        <div className="flex flex-col md:flex-row w-full justify-between items-center md:items-start md:p-4">
          <img src={book.imageurl} alt={book.title} className="w-full md:w-1/3" />
          <div className="md:w-2/3 md:ml-6">
            <h1 className="text-3xl font-bold mb-4">{book.title}</h1>
            <h2 className="text-xl font-semibold mb-4">{book.author}</h2>
            <p className="text-xl font-bold mb-4">${book.price}</p>
            <AddToCartButton book={book} handleAddToCart={handleAddToCart}/>
          </div>
        </div>
      </div>
    </div>
  );
};

export default BookDetailPage;
