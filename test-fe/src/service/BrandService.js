import axios from "axios";

const BRAND_API_BASE_URL='http://localhost:8386/brand';

class BrandService{
    async getBrands(){
        return await axios.get(BRAND_API_BASE_URL);
    }
}

export default new BrandService()