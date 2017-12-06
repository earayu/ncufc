import { observable, computed } from "mobx"


class UIStore{

    constructor(rootStore){
        this.rootStore = rootStore
    }

    //显示菜单
    @observable showSidebar = false;
    //菜单列表
    @observable menuList = ["主页海报", "球员信息"];
    //当前选择菜单选项
    @observable selectMenu = "";
    //已选图片，在框中显示
    @observable picInBox = false;
    @observable alertMsg = "";
    //正在上传
    @observable uploading = false;
    //待上传图片
    @observable cachedPic = null;

    @observable posterNameErrorText = ""

    @computed get showDialog(){
        return this.uploading || this.alertMsg !== ""
    }

    toggleSideBar(){
        this.showSidebar = !this.showSidebar
    }

}

export default UIStore