import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';
import { observer } from 'mobx-react';


const componentStyle = {
    appBar:{

    }
}

@observer class HeadBar extends Component{




    render(){
        return (
            <AppBar
                className="appBar"
                title="信工FC"
                style={componentStyle.appBar}
                onLeftIconButtonTouchTap={()=>{
                    this.props.store.uiStore.showSidebar = true
                }}
            />
        );
    }
}

export default HeadBar;
