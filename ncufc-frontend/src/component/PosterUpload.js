import React, { Component } from 'react';
import { inject, observer } from 'mobx-react';
import Paper from 'material-ui/Paper';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';
import Dialog from 'material-ui/Dialog';
import CircularProgress from 'material-ui/CircularProgress';


/**
 * 写前端会不由自主写成烂代码
 * @type {number}
 */


const PIC_BOX_WIDTH = 600
const PIC_BOX_HEIGHT = 400

const style = {
    height: 800,
    width: 1000,
    margin: 'auto',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
};

const picbox = {
    width: PIC_BOX_WIDTH,
    height: PIC_BOX_HEIGHT,
    display: 'flex',
    borderStyle: 'dashed',
    borderWidth: '5px',
    borderColor: '#AAAAAA',
    alignItems: 'center',
    justifyContent: 'center',
    overflow: 'hidden',
}

const formStyle = {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
}

const dialogStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
}


@inject('rootStore')
@observer
class PosterUpload extends Component{

    constructor(){
        super();
        this.menuItemName = "主页海报";
        this.addPics = this.addPics.bind(this);
        this.dialogContent = this.dialogContent.bind(this);
        this.dialogContent2 = this.dialogContent2.bind(this);
        this.file = {};
    }

    addPics(){
        if(this.ui.picInBox===false){
            return (
                <div>
                    <FloatingActionButton containerElement='label' // <-- Just add me!
                        label='My Label'
                        disabled={false}>
                        <ContentAdd id="posterPicker" />
                        <input type="file"  style={{display: 'none'}} onChange={this.handleClick.bind(this)}  />
                    </FloatingActionButton>
                </div>
            )
        }else {
            return (
                <div style={{position: 'relative'}}>
                    <img className="img" width={PIC_BOX_WIDTH} src={this.ui.cachedPic} />
                </div>
            )
        }
    }

    handleClick(e) {
        this.file = e.target.files[0]
        var reader = new FileReader();//创建一个读取文件对象reader
        reader.readAsDataURL(this.file);
        const store = this.props.store.uiStore;
        reader.onload = function () {
            store.addPoster.cachedPic = reader.result
        };
        this.ui.picInBox = true
    }

    handleCancelPic(){
        this.clearAll()
    }

    clearAll(){
        this.ui.picInBox= false;
        this.ui.alertMsg= "";
        this.ui.uploading= false;
        this.ui.cachedPic= null;
        this.ui.posterNameErrorText= "";
        document.querySelector("#posterName").value = ""
    }

    showUpload(){
        this.ui.uploading = true;
        this.ui.alertMsg = "";
        this.ui.posterNameErrorText = "";
    }

    showAlert(msg){
        this.ui.posterNameErrorText = ""
        this.ui.alertMsg = msg
        this.ui.uploading = false
    }

    showPreError(msg){
        this.ui.posterNameErrorText = msg
        this.ui.alertMsg = ""
        this.ui.uploading = false
    }

    /**
     *
     * 3. 前端压缩
     * 上传接口
     */
    handleUpload(){
        let textField = document.querySelector("#posterName")
        if(textField.value.trim()===""){
            this.showPreError("海报名称不能为空")
            return
        }
        if(this.file.name.slice(-3).toLowerCase()!=="jpg" && this.file.name.slice(-3).toLowerCase()!=="png"){
            this.showAlert("只能上传jpg或png格式的图片！")
            return
        }

        this.showUpload()
        let form = new FormData()
        form.append('poster', this.file)
        form.append('name', textField.value)
        form.append('postUser', 'earayu')//TODO 获取当前注册用户
        fetch( this.config.BASE_URL + "/api/v1/manage/poster",
            {
                method: 'POST',
                body: form
            }
        ).then(resp=> {
            resp.json().then(json=>{
                this.showAlert(json.message)
            })
        }).catch((error)=>{
            this.showAlert("接口调用异常！")
        })
    }

    /*
    * TODO
    * 1. 获取当前注册用户
    * 2. 后台校验name，相同不能上传
    * */

    dialogContent(){
        if(this.ui.uploading){
            return (
                <div>
                    <CircularProgress size={80} thickness={5} />
                </div>
            )
        }
    }

    dialogContent2(){
        if(this.ui.alertMsg !== ""){
            return (
                <div>
                    <p>{this.ui.alertMsg}</p>
                </div>
            )
        }
    }

    handleCloseAlert(){
        this.ui.alertMsg = ""
    }



    render(){
        this.ui = this.props.rootStore.uiStore.addPoster;
        this.config = this.props.rootStore.config;
        return (
            <Paper style={style} zDepth={5} >
                <div style={formStyle}>

                    {/*图片框*/}
                    <div id="picbox" style={picbox}>
                        {this.addPics()}
                    </div>

                    {/*海报名称输入框*/}
                    <div>
                        <TextField id="posterName"  hintText="海报名称" errorText={this.ui.posterNameErrorText} />
                    </div>

                    {/*转菊花、信息框*/}
                    <div>
                        <Dialog open={this.ui.uploading}>
                            {this.dialogContent()}
                        </Dialog>
                        <Dialog
                            open={this.ui.alertMsg!==""}
                            onRequestClose={this.handleCloseAlert.bind(this)}
                        >
                            {this.dialogContent2()}
                        </Dialog>
                    </div>

                    {/*重置、上传按钮*/}
                    <div>
                        <RaisedButton
                            disabled={this.ui.uploading}
                            label="重置"
                            labelPosition="before"
                            primary={true}
                            style={{width: '125px', marginRight:'5px'}}
                            onClick={this.handleCancelPic.bind(this)}
                        />
                        <RaisedButton
                            disabled={this.ui.uploading}
                            label="上传"
                            labelPosition="before"
                            primary={true}
                            style={{width: '125px', marginLeft:'5px'}}
                            onClick={this.handleUpload.bind(this)}
                        />
                    </div>

                </div>
            </Paper>
        )
    }




}

export default PosterUpload