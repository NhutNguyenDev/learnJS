import {products} from '../data/products.js';
import { cart, addToCart, updateCartQuanlity } from '../data/cart.js'


updateCartQuanlity();
const positionProduct = document.querySelector('.products-grid');
let htmlProduct = ``;
// We have import products.js into amazon.html, so this file can access "products in products.js"
products.forEach(product =>{
    // Genera html of each product
    htmlProduct += `<div class="product-container">
                        <div class="product-image-container">
                            <img class="product-image"
                                src="${product.image}">
                        </div>
                        <div class="product-name limit-text-to-2-lines">
                            ${product.name}
                        </div>

                        <div class="product-rating-container">
                            <img class="product-rating-stars"
                            src="images/ratings/rating-${product.rating.stars * 10}.png">
                            <div class="product-rating-count link-primary">
                            ${product.rating.count}
                            </div>
                        
                        </div>

                        <div class="product-price">
                            $${product.priceCents /100}
                        </div>
                        <div class="product-quantity-container">
                            <select id="product-quanlity-id-${product.id}">
                                <option selected value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                        <div class="product-spacer"></div>
                        <div class="added-to-cart">
                            <img src="images/icons/checkmark.png">
                            Added
                        </div>

                        <button class="add-to-cart-button button-primary js-add-to-cart" data-product-id="${product.id}" data-test="123">
                            Add to Cart
                        </button>

                    </div>`
});

positionProduct.innerHTML = htmlProduct;
const buttonAddToCart = document.querySelectorAll('.add-to-cart-button');
buttonAddToCart.forEach((product) => {
    product.addEventListener('click', () => {
        // Step 1: Get exacly id of product
        // console.log(product.dataset.productId);
        // Step 2: Save in localStorage

        let quanlity = document.getElementById('product-quanlity-id-' + product.dataset.productId).value;
        addToCart(product.dataset.productId, Number(quanlity));
        // Step 3: Update Carst Quanlity
        updateCartQuanlity();
        
    })
})




