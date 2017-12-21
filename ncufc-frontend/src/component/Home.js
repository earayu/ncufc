import React, { Component } from 'react';
import { inject, observer } from 'mobx-react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import ReactSwipe from 'react-swipe';
import HomePlayer from './HomePlayer'

const bannerbox = {
    width: "100%",
    position: "relative",
    overflow: "hidden",
    height: "900px",
}

const banner = {
    width:"3000px",
    position:"absolute",
    left:"50%",
    marginLeft:"-1500px",
    textAlign: "center"
}

const swipeOptions={
    startSlide: 0,
        speed: 400,
        auto: 3000,
        continuous: true,
        disableScroll: false,
        stopPropagation: false,
        callback: function(index, elem){
    },
    transitionEnd: function(index,elem){
    }
}

const style = {
    height: 100,
    width: 100,
    textAlign: 'center',
    display: 'inline-block',
};



@inject('rootStore')
@observer
export default class Home extends Component{

    constructor(){
        super()
        this.init()//TODO 在其他地方调用
        this.loadPosters = this.loadPosters.bind(this)
    }

    init(){
        this.loadPosters()
    }

    loadPosters(){
        //TODO base url
        fetch("http://localhost:8080" + "/api/v1/manage/poster", {
            method: 'GET'
        }).then(resp=> {
            resp.json().then(json=>{
                this.props.rootStore.uiStore.posters = json
            })
        }).catch((error)=>{
            this.showAlert("接口调用异常！")
        })
    }

    posters(){
        return this.props.rootStore.uiStore.posters.length && this.props.rootStore.uiStore.posters.map(poster=>{
            return (
                <div className="swipe" >
                    <Card>
                        <CardMedia overlay={<CardTitle title={poster.name} subtitle={poster.description} />}>
                            <div style={bannerbox}>
                                <div style={banner}>
                                    <img src={poster.url} />
                                </div>
                            </div>
                        </CardMedia>
                    </Card>
                </div>
            )
        })
    }


    render(){
        this.data = this.props.rootStore.uiStore;
        this.config = this.props.rootStore.config;
        return (
            <div>
                <ReactSwipe key={this.props.rootStore.uiStore.posters} swipeOptions={swipeOptions}>
                    {this.posters()}
                </ReactSwipe>
                <HomePlayer />

            </div>
        )


    }

}