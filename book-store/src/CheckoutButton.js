function CheckoutButton(props) {
  const cartItems = props.cartItems;
  const handleCheckout = props.handleCheckout;
    
  const totalItems = cartItems.reduce((total, item) => total + item.quantity, 0);
  const totalPrice = cartItems.reduce((total, item) => total + item.book.price * item.quantity, 0);
    
  return (
    <div className="flex flex-col gap-2">
      <div className="flex justify-between">
        <p className="font-bold">Total Items:</p>
        <p>{totalItems}</p>
      </div>
      <div className="flex justify-between">
        <p className="font-bold">Total Price:</p>
        <p>${totalPrice.toFixed(2)}</p>
      </div>
      <button onClick={handleCheckout} className="px-4 py-2 rounded-md bg-green-500 text-white hover:bg-green-600 transition-colors duration-200">Checkout</button>
    </div>
  );
}

export default CheckoutButton;





