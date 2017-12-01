import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';
import { observer } from 'mobx-react';


const componentStyle = {
    appBar:{

    }
}

const HeadBar = observer(class HeadBar extends Component{

    constructor(){
        super();
        this.state = {open: false}
    }

    render(){
        return (
            <AppBar
                className="appBar"
                title="My AppBar"
                style={componentStyle.appBar}
                onLeftIconButtonTouchTap={()=>{
                    alert(this.props.store.clicking)
                    this.props.store.clicking = true
                }}
            />
        );
    }
})

export default HeadBar;
