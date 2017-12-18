import { observable } from "mobx"

class Config{

    constructor(rootStore){
        this.rootStore = rootStore
    }

    @observable BASE_URL = "http://localhost:8080"

}



export default Config