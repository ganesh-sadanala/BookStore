import React from 'react';

function CartItemsAndQuantities(props) {
  const cartItems = props.cartItems;
  const updateQuantity = props.updateQuantity;
  
  return (
    <div className="flex flex-col gap-2">
      {cartItems.map((item) => (
        <div key={item.book.id} className="flex justify-between items-center bg-gray-100 rounded-md p-2">
          <div>
            <p className="font-bold">{item.book.title}</p>
            <p>{item.book.author}</p>
            <p className="text-gray-600">${item.book.price && item.book.price.toFixed(2)}</p>
          </div>
          <div className="flex items-center">
            <input type="number" min="1" value={item.quantity} onChange={(event) => updateQuantity(item.book.id, event.target.value)} className="w-16 p-1 rounded-md text-center border-gray-300" />
          </div>
        </div>
      ))}
    </div>
  );
}

export default CartItemsAndQuantities;