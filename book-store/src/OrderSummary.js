import React from 'react';
import PropTypes from 'prop-types';

function OrderSummary({ cartItems, subtotal, shipping, tax, total }) {
  return (
    <div className="bg-white p-4 rounded-lg shadow-lg">
      <h2 className="text-lg font-semibold mb-4">Order Summary</h2>
      <div className="flex justify-between mb-2">
        <p>Subtotal:</p>
        <p>{subtotal}</p>
      </div>
      <div className="flex justify-between mb-2">
        <p>Shipping:</p>
        <p>{shipping}</p>
      </div>
      <div className="flex justify-between mb-2">
        <p>Tax:</p>
        <p>{tax}</p>
      </div>
      <hr className="my-2" />
      <div className="flex justify-between">
        <p className="font-semibold">Total:</p>
        <p className="font-semibold">{total}</p>
      </div>
    </div>
  );
}

OrderSummary.propTypes = {
  cartItems: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
      author: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      quantity: PropTypes.number.isRequired,
    }),
  ).isRequired,
  subtotal: PropTypes.string.isRequired,
  shipping: PropTypes.string.isRequired,
  tax: PropTypes.string.isRequired,
  total: PropTypes.string.isRequired,
};

export default OrderSummary;