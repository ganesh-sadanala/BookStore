import React, { useState } from 'react';
import CartItemsAndQuantities from './CartItemsAndQuantities';
import CheckoutButton from './CheckoutButton';
import axios from 'axios';

function CartPage(props) {
  const [cartItems, setCartItems] = useState(props.cartItems);

  const updateQuantity = (id, quantity) => {
    const updatedItems = cartItems.map((item) => {
      if (item.book.id === id) {
        return { ...item, quantity: parseInt(quantity) };
      }
      return item;
    });
    setCartItems(updatedItems);
  };

  const handleCheckout = async () => {
    const orderItems = cartItems.map((item) => ({
      bookId: item.book.id,
      quantity: item.quantity,
      customerName: "localhost",
    }));

    try {
      const response = await axios.post('/orders', { orderItems });
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="mx-auto max-w-2xl p-4">
      <h1 className="text-3xl font-bold mb-4">Shopping Cart</h1>
      <CartItemsAndQuantities cartItems={cartItems} updateQuantity={updateQuantity} />
      <hr className="my-4" />
      <CheckoutButton cartItems={cartItems} handleCheckout={handleCheckout} />
    </div>
  );
}

export default CartPage;