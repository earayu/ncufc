import React, { Component } from 'react';
import { observer } from 'mobx-react';
import Paper from 'material-ui/Paper';


const style = {
    height: 500,
    width: 1000,
    margin: 'auto',
};

@observer
class PosterUpload extends Component{

    constructor(){
        super();
        this.menuItenName = "主页海报";
    }

    render(){
        return (
            <Paper style={style} zDepth={5} >
                123
            </Paper>
        )
    }
}

export default PosterUpload