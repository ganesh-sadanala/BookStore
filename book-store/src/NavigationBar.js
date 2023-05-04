import React from 'react';
import { Link } from 'react-router-dom';

const NavigationBar = ({ cartItems }) => {
  const cartItemCount = cartItems.reduce((acc, item) => acc + item.quantity, 0);

  return (
    <nav className="bg-gray-900 text-white p-4">
      <div className="max-w-7xl mx-auto flex justify-between">
        <Link to="/" className="text-xl font-bold">My Bookstore</Link>
        <ul className="flex space-x-4">
          <li>
            <Link to="/cart">
              Cart
              {cartItemCount > 0 && (
                <span className="ml-2 bg-green-500 rounded-full text-white px-2 py-1 text-xs">
                  {cartItemCount}
                </span>
              )}
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default NavigationBar;
