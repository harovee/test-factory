import axios from "axios";

const STATUS_API_BASE_URL='http://localhost:8386/status';

class StatusService{
    async getStatusList(){
        return await axios.get(STATUS_API_BASE_URL);
        console.log(axios.get(STATUS_API_BASE_URL));
        
    }
}

export default new StatusService()