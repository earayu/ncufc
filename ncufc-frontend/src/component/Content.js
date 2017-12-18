import React, { Component } from 'react';
import { observer } from 'mobx-react';
import PosterUpload from "./PosterUpload";
import PlayerUpload from "./PlayerUpload"





@observer
class Content extends Component{

    constructor(){
        super();
        this.showSelectedContent = this.showSelectedContent.bind(this);
    }

    showSelectedContent(){
        if(this.props.store.uiStore.selectMenu==='主页海报'){
            return (
                <PosterUpload store={this.props.store}/>
            )
        }else if(this.props.store.uiStore.selectMenu==='球员信息'){
            return (
                {/*<PlayerUpload store={this.props.store}/>*/}
            )
        }
    }

    render(){
        return (
            <div >
                {this.showSelectedContent()}
            </div>
        )
    }
}

export default Content;