import React from 'react'
import {Router, Route} from 'react-router'

import PosterUpload from './component/PosterUpload'
import App from './App'



const Routes = () => (
    <Router>
        <Route path="/" component={App}/>
        <Route path="posterUpload" component={PosterUpload}/>
    </Router>
)

export default Routes