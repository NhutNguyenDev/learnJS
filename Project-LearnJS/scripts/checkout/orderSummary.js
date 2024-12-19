import { cart, removeItemInCart, getNumberItemInCart } from "../../data/cart.js";
import { products } from "../../data/products.js";
import  dayjs from "https://unpkg.com/dayjs@1.11.10/esm/index.js";

export function renderOderSummary(){
    const cartSummaryHTML = document.querySelector(".order-summary");

// Update day delivery for each product
const today = dayjs();
const delivery7Date = today.add(7, "days");
const delivery3Date = today.add(3, "days");
const delivery1Date = today.add(1, "days");

// Render HTML product
let html = ``;
cart.forEach((product) => {
  // console.log(product.productId);
  const foundProduct = products.find(
    (productInCart) => productInCart.id === product.productId
  );
  let htmlProduct = `<div class="cart-item-container js-product-id-${
    product.productId
  }">
            <div class="delivery-date js-delivery-day-${product.productId}">
              Delivery date: ${delivery7Date.format("dddd, MMMM, D")}
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
                  <span class="delete-quantity-link link-primary js-delete-link" data-product-id="${
                    product.productId
                  }">
                    Delete
                  </span>
                </div>
              </div>

              <div class="delivery-options">
                <div class="delivery-options-title">
                  Choose a delivery option:
                </div>
                <div class="delivery-option">
                  <input type="radio" 
                    class="delivery-option-input js-delivery-option7-input-id-${
                      product.productId
                    }"
                    name="delivery-option-${product.productId}" checked>
                  <div>
                    <div class="delivery-option-date js-delivery-option-7-day" data-product-id="${
                      product.productId
                    }">
                      Tuesday, June 21 (CHANGE THIS)
                    </div>
                    <div class="delivery-option-price">
                      FREE Shipping
                    </div>
                  </div>
                </div>
                <div class="delivery-option">
                  <input type="radio"
                    class="delivery-option-input js-delivery-option3-input-id-${
                      product.productId
                    }"
                    name="delivery-option-${product.productId}">
                  <div>
                    <div class="delivery-option-date js-delivery-option-3-day" data-product-id="${
                      product.productId
                    }">
                      Wednesday, June 15 ( CHANGE THIS )
                    </div>
                    <div class="delivery-option-price">
                      $4.99 - Shipping
                    </div>
                  </div>
                </div>
                <div class="delivery-option">
                  <input type="radio"
                    class="delivery-option-input js-delivery-option1-input-id-${
                      product.productId
                    }"
                    name="delivery-option-${product.productId}">
                  <div>
                    <div class="delivery-option-date js-delivery-option-1-day" data-product-id="${
                      product.productId
                    }">
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
cartSummaryHTML.innerHTML = html;
updateNumberItemInCart()

// 7 day
document.querySelectorAll(".js-delivery-option-7-day").forEach((option) => {
  const day = delivery7Date.format("dddd, MMMM, D");
  option.innerHTML = day;

  // Add listener click for button check
  const optionProductId = option.dataset.productId;
  document
    .querySelector(`.js-delivery-option7-input-id-${optionProductId}`)
    .addEventListener("click", () => {
      document.querySelector(`.js-delivery-day-${optionProductId}`).innerHTML =
        "Delivery date: " + day;
    });
});
// 3 day
document.querySelectorAll(".js-delivery-option-3-day").forEach((option) => {
  const day = delivery3Date.format("dddd, MMMM, D");
  option.innerHTML = day;

  // Add listener click for button check
  const optionProductId = option.dataset.productId;
  document
    .querySelector(`.js-delivery-option3-input-id-${optionProductId}`)
    .addEventListener("click", () => {
      document.querySelector(`.js-delivery-day-${optionProductId}`).innerHTML =
        "Delivery date: " + day;
    });
});
// 1 day
document.querySelectorAll(".js-delivery-option-1-day").forEach((option) => {
  const day = delivery1Date.format("dddd, MMMM, D");
  option.innerHTML = day;

  // Add listener click for button check
  const optionProductId = option.dataset.productId;
  document
    .querySelector(`.js-delivery-option1-input-id-${optionProductId}`)
    .addEventListener("click", () => {
      document.querySelector(`.js-delivery-day-${optionProductId}`).innerHTML =
        "Delivery date: " + day;
    });
});

// Delete Item in Cart and Remove html element of that Item
document.querySelectorAll(".js-delete-link").forEach((link) => {
  link.addEventListener("click", () => {
    const productId = link.dataset.productId;

    removeItemInCart(productId);

    document.querySelector(".js-product-id-" + productId).remove();
    updateNumberItemInCart();
  });
});

function updateNumberItemInCart(){
  document.querySelector('.js-number-item-in-cart')
  .innerHTML = getNumberItemInCart() + " items";
}

}