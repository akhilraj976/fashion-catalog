import React from 'react';
const fetchJobs=require("../../services/GetProducts").getProducts

class ListProducts extends React.Component {
    constructor(props) {
        super(props);
       this.state = {products:[]};//using vanilla state as its a simple use case should use redux insted
      }
      

    componentDidMount() {
        fetchJobs()//using fetch as its esc default
            .then(res => res.json())
            .then((data) => {
                //console.log(JSON.stringify(data))
                this.setState({ products: data.splice(0,data.length-1) })
            })
            .catch(console.log);
    }
    render() {
        const items = this.state.products;

        return (
            <div>
                <ol>
                    {this.state.products.map((value, index) => {
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
                </ol>
            </div>
        );
    }
}

export default ListProducts;