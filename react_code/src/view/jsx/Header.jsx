import React from 'react';

import { Navbar, Nav, NavItem, Form, FormControl, Button, Container } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';

class Header extends React.Component {
  render() {
    return (
      <Container>
        <Navbar bg="light" variant="light">
          <nav className="mr-auto" >

            <NavLink className="main-anchor" activeClassName="selected" to="/">Home</NavLink> | &nbsp;
             <NavLink className="main-anchor" activeClassName="selected" to="/search">Search</NavLink> 
          </nav>
        </Navbar>
      </Container>
    );
  }
}


export default Header;