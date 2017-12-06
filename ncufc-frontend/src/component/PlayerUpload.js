import React, { Component } from 'react';
import { observer } from 'mobx-react';
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



@observer
class PlayerUpload extends Component{

    constructor(){
        super();
        this.menuItemName = "球员信息";
        this.addPics = this.addPics.bind(this);
        this.dialogContent = this.dialogContent.bind(this);
        this.dialogContent2 = this.dialogContent2.bind(this);
        this.uiStore = this.props.store.uiStore;
    }

    addPics(){
        if(this.props.store.uiStore.picInBox===false){
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
        }else {//TODO 添加取消图片按钮
            return (
                <div style={{position: 'relative'}}>
                    <img className="img" width={PIC_BOX_WIDTH} src={this.props.store.uiStore.cachedPic} />
                </div>
            )
        }
    }

    handleClick(e) {
        var reader = new FileReader();//创建一个读取文件对象reader
        reader.readAsDataURL(e.target.files[0]);
        const store = this.props.store.uiStore;
        reader.onload = function () {
            store.cachedPic = reader.result
        };
        this.props.store.uiStore.picInBox = true
    }

    handleCancelPic(){
        this.props.store.uiStore.picInBox = false
        this.props.store.uiStore.cachedPic = null
    }

    /**
     * 上传
     */
    handleUpload(){
        this.props.store.uiStore.uploading = true;
        let form = new FormData();
        form.append('poster', this.file, this.file.name)
        let textField = document.getElementById("posterName")
        if(textField.value===""){
            this.props.store.uiStore.posterNameErrorText = "海报名称不能为空！"
            this.props.store.uiStore.uploading = false
            return
        }
        this.props.store.uiStore.posterNameErrorText = ""
        form.append('name', textField.value)
        form.append('postUser', 'earayu')//TODO 获取当前注册用户
        fetch("http://localhost:8080/api/v1/manage/poster",
            {
                method: 'POST',
                body: form
            }
        ).then(resp=>{
            this.props.store.uiStore.uploading = false;
            if(resp.ok){
                return resp.json()
            }else {
                this.props.store.uiStore.alertMsg = "接口调用异常！"
            }
        }).then((j)=>{
            this.props.store.uiStore.alertMsg = j.message
        }).catch((error)=>{
            this.props.store.uiStore.alertMsg = "接口调用异常！"
        })
    }

    /*
    * TODO
    * 逻辑：
    * 1. 点击上传图片出现转菊花，上传按钮变灰
    * 2. 上传完成弹出dialog，上传按钮可点
    * 3. 校验name，相同不能上传
    * */

    dialogContent(){
        if(this.props.store.uiStore.uploading){
            return (
                <div>
                    <CircularProgress size={80} thickness={5} />
                </div>
            )
        }
    }

    dialogContent2(){
        if(this.props.store.uiStore.alertMsg !== ""){
            return (
                <div>
                    <p>{this.props.store.uiStore.alertMsg}</p>
                </div>
            )
        }
    }

    handleCloseAlert(){
        this.props.store.uiStore.alertMsg = ""
    }



    render(){
        return (
            <Paper style={style} zDepth={5} >
                <div style={formStyle}>
                    <div id="picbox" style={picbox}>
                        {this.addPics()}
                    </div>
                    <div>
                        <TextField id="posterName"  hintText="海报名称" errorText={this.props.store.uiStore.posterNameErrorText} />
                        <TextField id="posterName"  hintText="海报名称" errorText={this.props.store.uiStore.posterNameErrorText} />
                        <TextField id="posterName"  hintText="海报名称" errorText={this.props.store.uiStore.posterNameErrorText} />
                        <TextField id="posterName"  hintText="海报名称" errorText={this.props.store.uiStore.posterNameErrorText} />
                    </div>
                    <div>
                        <Dialog
                            open={this.props.store.uiStore.uploading}
                        >
                            {this.dialogContent()}
                        </Dialog>
                        <Dialog
                            open={this.props.store.uiStore.alertMsg!==""}
                            onRequestClose={this.handleCloseAlert.bind(this)}
                        >
                            {this.dialogContent2()}
                        </Dialog>
                    </div>
                    <div>
                        <RaisedButton
                            disabled={this.props.store.uiStore.uploading}
                            label="重置"
                            labelPosition="before"
                            primary={true}
                            style={{width: '125px', marginRight:'5px'}}
                            onClick={this.handleCancelPic.bind(this)}
                        />
                        <RaisedButton
                            disabled={this.props.store.uiStore.uploading}
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

export default PlayerUpload