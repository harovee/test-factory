import axios from "axios";

const PRODUCT_API_BASE_URL='http://localhost:8386/product';

class ProductService{
    async getProduct(){
        return await axios.get(PRODUCT_API_BASE_URL);
    }
}

export default new ProductService()