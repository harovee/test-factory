import axios from "axios";

const PRODUCT_API_BASE_URL='http://localhost:8386/product';
// const PRODUCT_DETAIL_API_URL=`http://localhost:8386/product/${id}`

class ProductService{
    async getProduct(){
        return await axios.get(PRODUCT_API_BASE_URL);
    };

    async getProductById(id) {
        return await axios.get(`http://localhost:8386/product/${id}`);
    }
}


export default new ProductService();
