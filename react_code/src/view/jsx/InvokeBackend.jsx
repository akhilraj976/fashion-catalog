import React from 'react';
import { Form, Button } from 'react-bootstrap';
const callBackend = require("../../services/CallSpring").callBackend


class InvokeBackend extends React.Component {
    constructor(props) {
        super(props);
        this.state = { backendData: {} };//using vanilla state as its a simple use case should use redux insted
    }

    fileCall(){
        callBackend()//using fetch as its esc default
            .then(res => res.json())
            .then((data) => {
                console.log(JSON.stringify(data))
                this.setState({ backendData: data })
            })
            .catch(console.log);
    }

    render() {
        const data = this.state.backendData;

        return (
            <div>
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Button inline variant="primary" onClick={(e) => this.fileCall()}>Call</Button>
                    </Form.Group>
                </Form>
                <ol>
                    {data.source}
                </ol>
            </div>
        );
    }
}

export default InvokeBackend;