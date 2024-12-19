import { cart } from "../../data/cart.js";
import { products } from "../../data/products.js";
export function renderPaymentSummary() {
  let priceAllItem = 0;
  let priceShipping = 0;

  cart.forEach((product) => {
    const idIProductInCart = product.productId;
    const quanlityProduct = product.quanlity;

    const productMatching = products.find(
      (productInProducts) => productInProducts.id === idIProductInCart
    );
    priceAllItem += (productMatching.priceCents * product.quanlity) /100 ;
    product.shippingCost && (priceShipping += product.shippingCost);
  });

  const paymentSummaryHTML = `
          <div class="payment-summary-title">Order Summary</div>

          <div class="payment-summary-row">
            <div>Items (3):</div>
            <div class="payment-summary-money">$${priceAllItem.toFixed(2)}</div>
          </div>

          <div class="payment-summary-row">
            <div>Shipping &amp; handling:</div>
            <div class="payment-summary-money">$${priceShipping}</div>
          </div>

          <div class="payment-summary-row subtotal-row">
            <div>Total before tax:</div>
            <div class="payment-summary-money">$${(priceAllItem + priceShipping).toFixed(2)}</div>
          </div>

          <div class="payment-summary-row">
            <div>Estimated tax (10%):</div>
            <div class="payment-summary-money">$${Math.round((priceAllItem + priceShipping)*0.1)}</div>
          </div>

          <div class="payment-summary-row total-row">
            <div>Order total:</div>
            <div class="payment-summary-money">$${(Math.round((priceAllItem + priceShipping)*0.1) + priceAllItem + priceShipping).toFixed(2)}</div>
          </div>

          <button class="place-order-button button-primary">
            Place your order
          </button>`;

    document.querySelector('.payment-summary').innerHTML = paymentSummaryHTML;

}
