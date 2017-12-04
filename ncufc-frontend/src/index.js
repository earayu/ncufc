import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import rootStore from './store/RootStore'

ReactDOM.render(<App store={rootStore} />, document.getElementById('root'));
