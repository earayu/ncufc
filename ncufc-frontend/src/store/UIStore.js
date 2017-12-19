import { observable, computed } from "mobx"


class UIStore{

    constructor(rootStore){
        this.rootStore = rootStore
    }

    //显示菜单
    @observable showSidebar = false;
    //菜单列表
    @observable menuList = [
        {
            url: "/PosterUpload",
            name: "主页海报"
        },
        {
            url: "PlayerInfo",
            name: "球员信息"
        }
    ];
    //当前选择菜单选项
    @observable selectMenu = "";



    //添加海报页面
    @observable addPoster = {
        picInBox: false,
        alertMsg: "",
        //正在上传
        uploading: false,
        //待上传图片
        cachedPic: null,
        posterNameErrorText: "",
    }

    @observable player = {
        //已选图片，在框中显示


    }


    @computed get showDialog(){
        return this.uploading || this.alertMsg !== ""
    }

    toggleSideBar(){
        this.showSidebar = !this.showSidebar
    }

}

export default UIStore