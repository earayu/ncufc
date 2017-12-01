import React, { Component } from 'react';
import Drawer from 'material-ui/Drawer';
import { observer } from 'mobx-react';

const componentStyle = {
    sideBar:{

    }
}

const SideBar = observer(class SideBar extends Component{
    render(){
        return (
            <Drawer
                docked={false}
                width={200}
                open={this.props.store.clicking}
                onRequestChange={(open) => this.setState({open})}
            >
            </Drawer>
        );
    }
})

export default SideBar;
