import React from 'react';
import { Link } from 'react-router-dom';

const BookCard = ({ book, handleBookClick }) => {
  return (
    <Link to={`/books/${book.id}`} className="book-card" onClick={() => handleBookClick(book)}>
    <img src={book.imageurl} alt={book.title} />
    <h3>{book.title}</h3>
    <p>{book.author}</p>
    <p className="book-price">${book.price.toFixed(2)}</p>
  </Link>
  );
};

export default BookCard;
