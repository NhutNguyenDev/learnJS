import { cart, removeItemInCart } from "../data/cart.js";
import { products } from "../data/products.js";

console.log(cart);

const elementContainProductInCart = document.querySelector(".order-summary");

let html = ``;
cart.forEach((product) => {
  // console.log(product.productId);
  const foundProduct = products.find(
    (productInCart) => productInCart.id === product.productId
  );
  console.log(foundProduct);
  let htmlProduct = `<div class="cart-item-container js-product-id-${
    product.productId
  }">
            <div class="delivery-date">
              Delivery date: Tuesday, June 21 ( CHANGE THIS 3 )
            </div>

            <div class="cart-item-details-grid">
              <img class="product-image"
                src="${foundProduct.image}">

              <div class="cart-item-details">
                <div class="product-name">
                  ${foundProduct.name}
                </div>
                <div class="product-price">
                  $${foundProduct.priceCents / 100}
                </div>
                <div class="product-quantity">
                  <span>
                    Quantity: <span class="quantity-label">${
                      product.quanlity
                    }</span>
                  </span>
                  <span class="update-quantity-link link-primary">
                    Update (Change this 2)
                  </span>
                  <span class="delete-quantity-link link-primary js-delete-link" data-product-id="${product.productId}">
                    Delete
                  </span>
                </div>
              </div>

              <div class="delivery-options">
                <div class="delivery-options-title">
                  Choose a delivery option:
                </div>
                <div class="delivery-option">
                  <input type="radio" checked
                    class="delivery-option-input"
                    name="delivery-option-1">
                  <div>
                    <div class="delivery-option-date">
                      Tuesday, June 21 (CHANGE THIS)
                    </div>
                    <div class="delivery-option-price">
                      FREE Shipping
                    </div>
                  </div>
                </div>
                <div class="delivery-option">
                  <input type="radio"
                    class="delivery-option-input"
                    name="delivery-option-1">
                  <div>
                    <div class="delivery-option-date">
                      Wednesday, June 15 ( CHANGE THIS )
                    </div>
                    <div class="delivery-option-price">
                      $4.99 - Shipping
                    </div>
                  </div>
                </div>
                <div class="delivery-option">
                  <input type="radio"
                    class="delivery-option-input"
                    name="delivery-option-1">
                  <div>
                    <div class="delivery-option-date">
                      Monday, June 13 ( CHANGE THIS )
                    </div>
                    <div class="delivery-option-price">
                      $9.99 - Shipping
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>`;
  html += htmlProduct;
});
elementContainProductInCart.innerHTML = html;

document.querySelectorAll('.js-delete-link')
.forEach((link) => {
  link.addEventListener('click', () => {
    const productId = link.dataset.productId;

    removeItemInCart(productId);

    document.querySelector('.js-product-id-' + productId).remove();
  });
});

