import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./HomePage";
import BookDetailPage from "./BookDetailPage";
import CartPage from "./CartPage";
import PaymentProcessing from "./PaymentProcessing";
import React from 'react';
import axios from 'axios';
import NavigationBar from "./NavigationBar";

class AppRouter extends React.Component {
  state = {
    books: [], // define books state here
    selectedBook: null, // define selectedBook state here
    cartItems: [], // define cartItems state here
    isLoading: true // define isLoading state here
  };

  handleBookClick = (book) => {
    this.setState({selectedBook:book});
  };

  handleAddToCart = (book, quantity) => {
    const { cartItems } = this.state;
    const existingItem = cartItems.find(item => item.book.id === book.id);

    if (existingItem) {
      existingItem.quantity += quantity;
      this.setState({ cartItems: cartItems });
    } else {
      const newItem = { book, quantity };
      this.setState({ cartItems: [...cartItems, newItem] });
    }
  };

  componentDidMount() {
    axios.defaults.baseURL = 'http://44.204.82.115:8080';
    // axios.defaults.baseURL = 'http://127.0.0.1:8080';
    axios.get('/books')
      .then(response => {
        this.setState({ books: response.data, isLoading: false });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render(){
    return (
      <Router>
        <NavigationBar cartItems={this.state.cartItems} />
        {this.state.isLoading ?
          <div>Loading books...</div> :
          <Routes>
            <Route exact path="/" element={<HomePage handleBookClick={this.handleBookClick} books={this.state.books} />} />
            <Route exact path="/books/:id" element={<BookDetailPage book={this.state.selectedBook} handleAddToCart={this.handleAddToCart}/> } />
            <Route exact path="/cart" element={<CartPage cartItems={this.state.cartItems} handleCheckout={this.handleCheckout} />} />
            <Route exact path="/payment" element={PaymentProcessing} />
          </Routes>
        }
      </Router>
    );
  }
}

export default AppRouter;
