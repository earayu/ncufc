import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';
import HeadBar from './component/HeadBar';
import { observer } from 'mobx-react';
import SideBar from "./component/SideBar";
import { Link, Route, Switch } from 'react-router-dom';
import PosterUpload from './component/PosterUpload'
import Home from './component/Home'
import HomePlayer from './component/HomePlayer'

injectTapEventPlugin();

const AppStyle = {
    app:{
        display: 'flex',
        flexDirection: 'column'
    },

}




class App extends Component {
  render() {
    return (
        <div className="App" style={AppStyle.app}>
            <MuiThemeProvider  >
                <HeadBar/>
                <SideBar/>
                {/*<Content store={this.props.store}/>*/}

                <Route exact={true} path="/" component={Home}/>
                <Route path="/HomePlayer" component={HomePlayer}/>
                <Route path="/PosterUpload" component={PosterUpload}/>

            </MuiThemeProvider>


        </div>
    );
  }
}

export default observer(App);
