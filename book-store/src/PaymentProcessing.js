import { useEffect, useState } from "react";
import {
  PayPalScriptProvider,
  PayPalButtons,
  usePayPalScriptReducer,
} from "@paypal/react-paypal-js";

const PaymentProcessing = ({ total, onPaymentSuccess }) => {
  const [paid, setPaid] = useState(false);

  const [{ options, isPending }, dispatch] = usePayPalScriptReducer();

  useEffect(() => {
    dispatch({
      type: "resetOptions",
      value: {
        ...options,
        currency: "USD",
      },
    });
  }, []);

  const handlePaymentSuccess = () => {
    setPaid(true);
    onPaymentSuccess();
  };

  return (
    <PayPalButtons
      style={{ layout: "vertical" }}
      disabled={false}
      forceReRender={[total]}
      createOrder={(data, actions) => {
        return actions.order
          .create({
            purchase_units: [
              {
                amount: {
                  currency_code: "USD",
                  value: total,
                },
              },
            ],
          })
          .then((orderId) => {
            // Your code here after create the order
            return orderId;
          });
      }}
      onApprove={(data, actions) => {
        return actions.order
          .capture()
          .then(() => {
            // Your code here after capture the order
            handlePaymentSuccess();
          })
          .catch((err) => console.error(err));
      }}
    />
  );
};

const App = () => {
  const [paymentSuccess, setPaymentSuccess] = useState(false);

  const handlePaymentSuccess = () => {
    setPaymentSuccess(true);
  };

  return (
    <div style={{ maxWidth: "750px", minHeight: "200px" }}>
      {!paymentSuccess && (
        <PayPalScriptProvider
          options={{
            "client-id": "YOUR_PAYPAL_CLIENT_ID",
            components: "buttons",
          }}
        >
          <PaymentProcessing
            total={10} // Replace with your total amount
            onPaymentSuccess={handlePaymentSuccess}
          />
        </PayPalScriptProvider>
      )}
      {paymentSuccess && (
        <>
          <h2>Payment Successful</h2>
          <p>Thank you for your order!</p>
        </>
      )}
    </div>
  );
};

export default App;
