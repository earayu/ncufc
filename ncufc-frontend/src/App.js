import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';
import HeadBar from './component/HeadBar';
import { observer } from 'mobx-react';
import SideBar from "./component/SideBar";
import Content from './component/Content'



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
                <HeadBar store={this.props.store}/>
                <SideBar store={this.props.store}/>
                <Content store={this.props.store}/>
            </MuiThemeProvider>
      </div>
    );
  }
}

export default observer(App);
