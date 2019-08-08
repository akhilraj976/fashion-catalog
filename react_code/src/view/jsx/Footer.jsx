import React from 'react';
import { Nav, NavItem, Container } from 'react-bootstrap';

function Footer(/*props*/) {
  return (
    <Container>
      <footer>

        <Nav justified>
          <NavItem
            eventkey={1}>

          </NavItem>
          <NavItem
            eventkey={2}
            title="Item">

          </NavItem>
          <NavItem
            eventkey={3}>

          </NavItem>
        </Nav>

        <div className="text-center small copyright">
          © AKHIL 2019
        </div>
      </footer>
    </Container>
  );
}

export default Footer;