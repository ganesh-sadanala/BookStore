import React from 'react';
import OrderDetails from './OrderDetails';
import ThankYouMessage from './ThankYouMessage';

function OrderConfirmationPage() {
  return (
    <div>
      <h1 className="text-3xl font-bold my-4">Order Confirmation</h1>
      <OrderDetails />
      <ThankYouMessage />
    </div>
  );
}

export default OrderConfirmationPage;
