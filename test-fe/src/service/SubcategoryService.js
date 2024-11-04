import axios from "axios";

const SUBCATEGORY_API_BASE_URL='http://localhost:8386/sub-cate';

class SubCateService{
    async getSubCategories(){
        return await axios.get(SUBCATEGORY_API_BASE_URL);
    }
}

export default new SubCateService();