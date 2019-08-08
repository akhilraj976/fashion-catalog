import React from 'react';
import { Form,Button } from 'react-bootstrap';
const searchProducts=require("../../services/GetProducts").searchProducts;
class SearchProduct extends React.Component {

    constructor(props) {
        super(props);
       this.state = {searchedproducts:[]};//using vanilla state as its a simple use case should use redux insted
      }

    fireSearchAPI() {
        let title=this.state.searchToken;
        searchProducts(title)//using fetch as its esc default
        .then(res => res.json())
        .then((data) => {
            console.log(JSON.stringify(data))
            this.setState({ searchedproducts: data })
        })
        .catch(console.log);

      }
       readTextBoxValue(e){
        //console.log(e.target.value)
        this.setState({searchToken:e.target.value});
      }


    render() {
        
        return (
            <div>
            <Form>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label inline >Enter product details</Form.Label>
                    <Form.Control inline type="test" placeholder="Title or Brand" onChange={e=>this.readTextBoxValue(e)}/>
                    <Button inline variant="primary" onClick={(e)=>this.fireSearchAPI()}>Search</Button>
                </Form.Group>
            </Form>
            <div>
                {this.state.searchedproducts.map((value, index) => {
                        return <div>
								<table>
									<tr>
										<td>
										<img src={value.imageUrl} alt="Jeans" height="200" width="200"/></td>
									</tr>
									<tr align="center">
										<td>
										{value.title}</td>
									</tr>
									<tr align="center">
										<td>
										{value.price}$</td>
									</tr>
								</table>
								</div>
                })}
            </div>
            </div>
        );

    }

}

export default SearchProduct;