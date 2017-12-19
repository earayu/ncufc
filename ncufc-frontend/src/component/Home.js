import React, { Component } from 'react';
import { inject, observer } from 'mobx-react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';


const bannerbox = {
    width: "100%",
    position: "relative",
    overflow: "hidden",
    height: "800px",
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


    render(){
        return (
            <Card>
                <CardMedia overlay={<CardTitle title="Overlay title" subtitle="Overlay subtitle" />}>
                    <div style={bannerbox}>
                        <div style={banner}>
                            <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513696517649&di=6bdc22108d461b246f482645e41ccf46&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D1859455020%2C506700864%26fm%3D214%26gp%3D0.jpg" />
                        </div>
                    </div>
                </CardMedia>
            </Card>
        )
    }

}