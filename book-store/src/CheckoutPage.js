import React, { useState } from 'react';
import ShippingAndBillingInformation from './ShippingAndBillingInformation';
import OrderSummary from './OrderSummary';
import PaymentProcessing from './PaymentProcessing';

const CheckoutPage = () => {
  const [billingInfo, setBillingInfo] = useState({});
  const [shippingInfo, setShippingInfo] = useState({});
  const [paymentInfo, setPaymentInfo] = useState({});

  // Function to handle form submission
  const handleFormSubmit = (event) => {
    event.preventDefault();
    // Do something with the billingInfo, shippingInfo, and paymentInfo objects
    console.log('Billing Info:', billingInfo);
    console.log('Shipping Info:', shippingInfo);
    console.log('Payment Info:', paymentInfo);
  };

  return (
    <div className="container mx-auto p-4">
      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <ShippingAndBillingInformation
          billingInfo={billingInfo}
          setBillingInfo={setBillingInfo}
          shippingInfo={shippingInfo}
          setShippingInfo={setShippingInfo}
        />
        <OrderSummary />
      </div>
      <PaymentProcessing
        currency='inr'
        showSpinner={true}
      />
    </div>
  );
};

export default CheckoutPage;
