
async function loadProducts() {

    const request = await fetch("/api/product", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    })

    const products = await request.json();
    if (Array.from(products).length === 0){
        return [];
    }
    console.log(products, "Fetching products")
    renderProducts(products);
}

loadProducts().then(x => console.log("all ok"));

function renderProducts(products) {


    const htmlProduct = products.reduce((acm, product) =>{
        return acm + `
            <div class="box">
      <span class="discount">-${product.discount}%</span>
      <div class="icons">
        <a href="#" class="fas fa-heart"></a>
        <a href="#" class="fas fa-share"></a>
        <a onclick="getProductDetail()" class="fas fa-eye"></a>
      </div>
      <img src="${product.url}" alt="">
      <h3>${product.name}</h3>
      <div class="stars">
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="fas fa-star"></i>
        <i class="far fa-star"></i>
      </div>
      <div class="quantity">
        <span> cantidad : </span>
        <input type="number" min="1" max="100" value="1">
      </div>
      <div class="price">$${product.price - ((product.price * product.discount) / 100)} <span>$${product.price}</span></div>
      <a href="#" class="btn buy" data-id="${product.id}">Agregar al Carrito</a>
    </div>`;
    }, "");

    const productsHTML = document.querySelector("#cardBox").outerHTML = htmlProduct;
    console.log(productsHTML);
}


function getProductDetail (){
    return window.location.href = "product.html";
}