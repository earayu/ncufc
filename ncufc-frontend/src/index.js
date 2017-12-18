import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import rootStore from './store/RootStore'
import Routes from './Route'

ReactDOM.render(
    <Routes store={rootStore} />, document.getElementById('root')
);
