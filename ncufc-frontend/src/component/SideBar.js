import React, { Component } from 'react';
import Drawer from 'material-ui/Drawer';
import { observer } from 'mobx-react';
import Menu from 'material-ui/Menu';
import MenuItem from 'material-ui/MenuItem';



@observer
class SideBar extends Component{

    constructor(){
        super()
        this.getMenuList = this.getMenuList.bind(this);
    }

    handleMenuClick(event, item, index){
        this.props.store.uiStore.selectMenu = item.props.children
        this.props.store.uiStore.toggleSideBar()
    }

    getMenuList(){
        return (
            this.props.store.uiStore.menuList.map((m)=>{
                return <MenuItem>{m}</MenuItem>
            })
        )
    }

    render(){
        return (
            <Drawer
                docked={false}
                width={200}
                open={this.props.store.uiStore.showSidebar}
                onRequestChange={
                    open => {
                        this.props.store.uiStore.toggleSideBar()
                    }
                }
            >
                <Menu onItemTouchTap={this.handleMenuClick.bind(this)}>
                    {this.getMenuList()}
                </Menu>
            </Drawer>
        );
    }
}

export default SideBar;
