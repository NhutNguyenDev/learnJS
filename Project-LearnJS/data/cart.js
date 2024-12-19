import { renderPaymentSummary } from "../scripts/checkout/paymentSummary.js";

export let cart = JSON.parse(localStorage.getItem("cart"));

if (!cart) {
  cart = [];
}

export function addToCart(productId, quanlity) {
  let containInCart = 0;
  cart.forEach((productInCart) => {
    if (productInCart.productId === productId) {
      productInCart.quanlity += quanlity;
      containInCart = 1;
    }
  });
  if (!containInCart) {
    cart.push({
      productId: productId,
      quanlity: quanlity,
    });
  }
  updateCart();
}

export function updateCartQuanlity() {
  let cartQuanlity = 0;

  cart.forEach((product) => {
    cartQuanlity += product.quanlity;
  });
  // console.log("Cart quanlity: " + cartQuanlity);
  document.querySelector(".js-cart-quanlity").innerHTML = cartQuanlity;
}

export function removeItemInCart(productId) {
  const newCart = [];
  cart.forEach((cartItem) => {
    if (cartItem.productId !== productId) {
      newCart.push(cartItem);
    }
  });
  cart = newCart;
  updateCart();
}

export function getNumberItemInCart() {
  let numberItem = 0;
  cart.forEach((product) => {
    numberItem += 1;
  });
  return numberItem;
}

export function addShippingCost(productId, price) {
  const productInCart = cart.find((product) => product.productId === productId);
  productInCart.shippingCost = price / 100;
}
export function decreaseQuanlityItem(productIdDecrease){
  const productMaching = cart.find((productItem) => productItem.productId === productIdDecrease);
  if(productMaching.quanlity != 1){
    productMaching.quanlity -= 1;
    updateCart();
    renderPaymentSummary();
  } else {
    removeItemInCart(productIdDecrease);
    document.querySelector(".js-product-id-" + productIdDecrease).remove();
    renderPaymentSummary();
  }
}
export function increaseQuanlityItem(productIdIncrease){
  const productMaching = cart.find((productItem) => productItem.productId === productIdIncrease);
    productMaching.quanlity += 1;
    updateCart();
    renderPaymentSummary();
}
function updateCart() {
  localStorage.setItem("cart", JSON.stringify(cart));
}

