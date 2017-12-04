import { observable } from "mobx"


class UIStore{

    constructor(rootStore){
        this.rootStore = rootStore
    }

    //显示菜单
    @observable showSidebar = false;
    //菜单列表
    @observable menuList = ["主页海报", "其他"];
    //当前选择菜单选项
    @observable selectMenu = "";
    //已选图片，在框中显示
    @observable picInBox = false;

    toggleSideBar(){
        this.showSidebar = !this.showSidebar
    }

}

export default UIStore