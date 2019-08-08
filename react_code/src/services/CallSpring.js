const callBackend = () => {
    return fetch('http://localhost:8085/rest/server');
}

module.exports.callBackend = callBackend;