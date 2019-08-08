import React from 'react';
import { Container } from 'react-bootstrap';
//import { Glyphicon } from 'react-bootstrap';
import Header from './Header.jsx';
import Footer from './Footer.jsx';

import SearchProduct from './SearchProduct.jsx';
import ListProducts from './ListProducts.jsx';
import InvokeBackend from './InvokeBackend.jsx';
/* import {
    BrowserRouter as Router,
    Link,
    Route,
    Switch,
  } from 'react-router-dom'; */

import { Router, Route, Switch } from 'react-router';
const createHistory = require("history").createBrowserHistory;
class App extends React.Component {
    render() {
        const history = createHistory();
        return (
            <div>
                <Router history={history}>
                    <Header />
                    <Container>
                        <div>
                            <Switch>
                                <Route exact path="/" component={ListProducts} />
                                <Route exact path="/search" component={SearchProduct} />
                                <Route exact path="/list" component={ListProducts} />
                                <Route exact path="/spring" component={InvokeBackend} />
                            </Switch>
                        </div>
                    </Container>
                </Router>

                <Footer />
            </div>
        );
    }
}

export default App;