// import React, { Component } from 'react';
// import { inject,observer } from 'mobx-react';
// import PosterUpload from "./PosterUpload";
// import PlayerUpload from "./PlayerUpload"
//
//
//
//
//
// @inject('rootStore')
// @observer
// class Content extends Component{
//
//     constructor(){
//         super();
//         this.showSelectedContent = this.showSelectedContent.bind(this);
//     }
//
//     showSelectedContent(){
//         if(this.props.rootStore.uiStore.selectMenu==='主页海报'){
//             return (
//                 <PosterUpload store={this.props.store}/>
//             )
//         }else if(this.props.rootStore.uiStore.selectMenu==='球员信息'){
//             return (
//                 {/*<PlayerUpload store={this.props.store}/>*/}
//             )
//         }
//     }
//
//     render(){
//         return (
//             <div >
//                 {this.showSelectedContent()}
//             </div>
//         )
//     }
// }
//
// export default Content;