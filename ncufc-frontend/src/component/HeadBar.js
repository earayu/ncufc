import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';
import { inject, observer } from 'mobx-react';


const componentStyle = {
    appBar:{

    }
}
@inject('rootStore')
@observer class HeadBar extends Component{




    render(){
        return (
            <AppBar
                className="appBar"
                title="信工FC"
                style={componentStyle.appBar}
                onLeftIconButtonTouchTap={()=>{
                    this.props.rootStore.uiStore.showSidebar = true
                }}
            />
        );
    }
}

export default HeadBar;
