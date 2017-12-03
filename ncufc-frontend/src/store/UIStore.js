import { observable } from "mobx"


class UIStore{

    constructor(rootStore){
        this.rootStore = rootStore
    }

    @observable showSidebar = false;
    @observable menuList = ["主页海报", "其他"];
    @observable selectMenu = "";

    toggleSideBar(){
        this.showSidebar = !this.showSidebar
    }

}

export default UIStore