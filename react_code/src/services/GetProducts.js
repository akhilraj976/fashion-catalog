const getProducts = () => {
    return fetch('http://localhost:8080/fashion/v1/products');
}

const searchProducts = (title) => {
    return fetch('http://localhost:8080/fashion/v1/products/search?title=' + title) //using fetch as its esc default
}
module.exports.getProducts = getProducts;
module.exports.searchProducts = searchProducts;