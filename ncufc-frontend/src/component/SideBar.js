import React, { Component } from 'react';
import Drawer from 'material-ui/Drawer';
import { inject,observer } from 'mobx-react';
import Menu from 'material-ui/Menu';
import MenuItem from 'material-ui/MenuItem';
import { Link} from 'react-router-dom';
import {withRouter} from "react-router-dom";

@withRouter
@inject("rootStore")
@observer
class SideBar extends Component{

    constructor(){
        super()
        this.getMenuList = this.getMenuList.bind(this);
    }

    handleMenuClick(event, item, index){
        console.log(item.props.value)
        this.props.history.push(item.props.value)
        this.props.rootStore.uiStore.toggleSideBar()
    }

    getMenuList(){
        return (
            this.props.rootStore.uiStore.menuList.map((m)=>{
                return (
                        <MenuItem value={m.url}>
                            {m.name}
                        </MenuItem>
                )
            })
        )
    }

    render(){
        return (
            <Drawer
                docked={false}
                width={200}
                open={this.props.rootStore.uiStore.showSidebar}
                onRequestChange={
                    open => {
                        this.props.rootStore.uiStore.toggleSideBar()
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
