import React from 'react';
import NavigationBar from './NavigationBar';
import HomePage from './HomePage';
import CategoryPage from './CategoryPage';
import BookDetailPage from './BookDetailPage';
import CartPage from './CartPage';
import CheckoutPage from './CheckoutPage';
import OrderConfirmationPage from './OrderConfirmationPage';

class App extends React.Component {
  state = {
    books: [], // define books state here
    selectedBook: null, // define selectedBook state here
    cartItems: [], // define cartItems state here
  };

  // other code ...

  render() {
    return (
      <div>
        <NavigationBar />
        <HomePage books={this.state.books} />
        <CategoryPage books={this.state.books} />
        <BookDetailPage book={this.state.selectedBook} /> 
        <CartPage cartItems={this.state.cartItems} updateQuantity={this.updateCartQuantity} handleCheckout={this.handleCheckout} />
        <CheckoutPage />
        <OrderConfirmationPage />
      </div>
    );
  }
}

export default App;
