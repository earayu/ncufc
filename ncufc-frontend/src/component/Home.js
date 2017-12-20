import React, { Component } from 'react';
import { inject, observer } from 'mobx-react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import ReactSwipe from 'react-swipe';


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



@inject('rootStore')
@observer
export default class Home extends Component{

    constructor(){
        super()
        this.init()
    }

    init(){
        alert("init")
        this.loadPosters()
        alert("init2")
    }

    loadPosters(){
        //TODO base url
        fetch("http://localhost:8080" + "/api/v1/manage/poster", {
            method: 'GET'
        }).then(resp=> {
            resp.json().then(json=>{
                this.props.rootStore.homeStore.posters = json
            })
        }).catch((error)=>{
            this.showAlert("接口调用异常！")
        })
    }



    render(){
        this.data = this.props.rootStore.homeStore;
        this.config = this.props.rootStore.config;
        return (
            <ReactSwipe
                key = {3}
                swipeOptions={{
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
                }}>
                {
                    this.props.rootStore.homeStore.postersg.map(poster=>{
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
            </ReactSwipe>








        )
    }

}