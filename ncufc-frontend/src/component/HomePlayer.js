import React, { Component } from 'react';
import {GridList, GridTile} from 'material-ui/GridList';
import IconButton from 'material-ui/IconButton';
import StarBorder from 'material-ui/svg-icons/toggle/star-border';
import { inject, observer } from 'mobx-react';
import Paper from 'material-ui/Paper';
import ReactSwipe from 'react-swipe';



const style = {
    height: 600,
    width: 400,
    margin: 20,
    textAlign: 'center',
    display: 'inline-block',
};


const swipeOptions={
    startSlide: 3,
    speed: 300,
    auto: 1000,
    continuous: true,
    disableScroll: false,
    stopPropagation: false,
    callback: function(index, elem){
    },
    transitionEnd: function(index,elem){
    }
}




@inject("rootStore")
@observer
class HomePlayer extends Component{
    constructor(){
        super()
    }

    render(){
        return (
            <div>
                <ReactSwipe key={this.props.rootStore.uiStore.players} swipeOptions={swipeOptions}>
                    <div class='swipe-wrap' style={{
                        float: 'left',
                        width: '25%',
                        position: 'relative',
                    }}>
                        <Paper style={style} zDepth={5} rounded={false} />
                    </div>
                    
                    <div class='swipe-wrap' style={{
                        float: 'left',
                        width: '25%',
                        position: 'relative',
                    }}>
                        <Paper style={style} zDepth={5} rounded={false} />
                    </div>
                    <div class='swipe-wrap' style={{
                        float: 'left',
                        width: '25%',
                        position: 'relative',
                    }}>
                        <Paper style={style} zDepth={5} rounded={false} />
                    </div>
                    <div class='swipe-wrap' style={{
                        float: 'left',
                        width: '25%',
                        position: 'relative',
                    }}>
                        <Paper style={style} zDepth={5} rounded={false} />
                    </div>
                </ReactSwipe>

            </div>
        )
    }

}

export default HomePlayer;