import React, { Component } from 'react';
import { observer } from 'mobx-react';
import Paper from 'material-ui/Paper';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';

const style = {
    height: 800,
    width: 1000,
    margin: 'auto',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
};

const picbox = {
    width: 600,
    height: 400,
    display: 'flex',
    borderStyle: 'dashed',
    borderWidth: '5px',
    borderColor: '#AAAAAA',
    alignItems: 'center',
    justifyContent: 'center',
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
    }

    addPics(){
        if(this.props.store.uiStore.picInBox===false){
            return (
                <form id="uploadForm" enctype="multipart/form-data">
                    <input id="file" type="file" name="file"/>
                    <button id="upload" type="button">upload</button>
                </form>
                /*<FloatingActionButton disabled={false}>*/
                    /*<ContentAdd id="posterPicker"/>*/
                /*</FloatingActionButton>*/
            )
        }else {
            return (
                <div>123</div>
            )
        }
    }

    render(){
        return (
            <Paper style={style} zDepth={5} >
                <div style={formStyle}>
                    <div style={picbox}>
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
                    />
                </div>
            </Paper>
        )
    }




}

export default PosterUpload