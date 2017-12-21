import React, { Component } from 'react';
import AppBar from 'material-ui/AppBar';
import { inject, observer } from 'mobx-react';
import Badge from 'material-ui/Badge';
import IconButton from 'material-ui/IconButton';
import NotificationsIcon from 'material-ui/svg-icons/social/notifications';

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
                iconElementRight={
                    <Badge badgeContent={3} secondary={true} badgeStyle={{top: 20, right: 20}}>
                        <IconButton tooltip="Notifications">
                            <NotificationsIcon />
                        </IconButton>
                    </Badge>
                }
                style={componentStyle.appBar}
                onLeftIconButtonTouchTap={()=>{
                    this.props.rootStore.uiStore.showSidebar = true
                }}
            />
        );
    }
}

export default HeadBar;
