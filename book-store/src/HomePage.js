import React from 'react';
import BookCard from './BookCard';

class HomePage extends React.Component {

  render() {
    return (
      <div className='container mx-auto px-4 sm:px-6 lg:px-8 py-8'>
        <div className='grid grid-cols-1 gap-6 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4'>
          {this.props.books.map((book) => {
            return <BookCard key={book.id} book={book} handleBookClick={this.props.handleBookClick} />
          })}
        </div>
      </div>
    );
  }
}

export default HomePage;
