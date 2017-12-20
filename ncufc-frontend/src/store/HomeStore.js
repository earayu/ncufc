import { observable, computed } from "mobx"

export default class HomeStore{
    constructor(rootStore){
        this.rootStore = rootStore;
    }
    /**
     * 1. url
     * 2. name
     * 3. group
     * 4. description
     * 5. postUser
     */
    @observable posters = [

    ]

}