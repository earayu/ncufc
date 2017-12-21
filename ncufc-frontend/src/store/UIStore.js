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
            url: "/",
            name: "官网主页"
        },
        {
            url: "/PosterUpload",
            name: "海报上传"
        },
        {
            url: "/HomePlayer",
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
        posterNameErrorText: "",
    }

    @observable cachedPic= null;


    @observable posters = [

    ];

    @observable players = [

    ];

    @observable refresh = false



    @computed get showDialog(){
        return this.uploading || this.alertMsg !== ""
    }

    toggleSideBar(){
        this.showSidebar = !this.showSidebar
    }

}

export default UIStore