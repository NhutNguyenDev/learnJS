export let cart = JSON.parse(localStorage.getItem('cart'));

if(!cart){
    cart = []
}

export function addToCart(productId, quanlity){
    let containInCart = 0;
        cart.forEach(productInCart => {
            if(productInCart.productId === productId){
                productInCart.quanlity += quanlity;
                containInCart = 1;
            }
        });
        if(!containInCart){
            cart.push({
                productId:productId,
                quanlity: quanlity
            })
        }
        localStorage.setItem('cart', JSON.stringify(cart));
}

export function updateCartQuanlity(){
    let cartQuanlity = 0;

        cart.forEach(product => {
            cartQuanlity += product.quanlity;
        });
        // console.log("Cart quanlity: " + cartQuanlity);
        document.querySelector('.js-cart-quanlity').innerHTML = cartQuanlity;
}

export function removeItemInCart(productId){
    const newCart = [];
    cart.forEach(cartItem => {
      if(cartItem.productId !== productId){
        newCart.push(cartItem);
      }
    });
    cart = newCart;
    localStorage.setItem('cart', JSON.stringify(cart));
}