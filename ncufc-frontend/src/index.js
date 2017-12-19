import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
// import stores from './store/sotres';
import rootStore from './store/RootStore'
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'mobx-react';


ReactDOM.render(
        <BrowserRouter >
            <Provider rootStore={rootStore}>
                <App />
            </Provider>
        </BrowserRouter>
    ,
    document.getElementById('root')
);
