import React, { Component } from 'react';
import { observer } from 'mobx-react';
import Paper from 'material-ui/Paper';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';

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

@observer
class PosterUpload extends Component{

    constructor(){
        super();
        this.menuItenName = "主页海报";
        this.addPics = this.addPics.bind(this);
        this.file = {};
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
            var reader = new FileReader();//创建一个读取文件对象reader
            reader.readAsDataURL(this.file);
            reader.onload = function() {//文件读取成功后 打印出数据结果，
                var box = document.getElementById("picbox")
                var img = document.createElement("img")
                img.src = reader.result
                img.width = PIC_BOX_WIDTH
                box.appendChild(img)
            }
        }
    }

    handleClick(e) {
        this.file = e.target.files[0]
        this.props.store.uiStore.picInBox = true
    }

    handleUpload(){
        let form = new FormData();
        form.append('poster', this.file, this.file.name)
        form.append('name', 'earayu')
        fetch("http://localhost:8080/api/v1/manage/poster",
            {
                method: 'POST',
                body: form
            }

        )
    }

    render(){
        return (
            <Paper style={style} zDepth={5} >
                <div style={formStyle}>
                    <div id="picbox" style={picbox}>
                        {this.addPics()}
                    </div>
                    <div >
                        <TextField hintText="Hint Text1" />
                    </div>
                    <div>
                        <TextField hintText="Hint Text2" />
                    </div>
                    <div>
                        <TextField hintText="Hint Text3" />
                    </div>
                    <div>
                        <TextField hintText="Hint Text4" />
                    </div>
                    <div>
                        <TextField hintText="Hint Text5" />
                    </div>
                    <RaisedButton
                        label="上传"
                        labelPosition="before"
                        primary={true}
                        style={{width: '260px'}}
                        onClick={this.handleUpload.bind(this)}
                    />
                </div>
            </Paper>
        )
    }




}

export default PosterUpload