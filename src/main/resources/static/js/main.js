function isValidFields(...params) {
    let isValid = true;
    params.forEach(param => {
        if (param === null || param === undefined || param.length === 0) {
            isValid = false
        }
    })
    return isValid;
}

function sendRequest(type, url, data, functionSucces, functionError) {
    let request = {};

    request.type = type;
    request.url = url;

    if (isValidFields(data)) {
        request.data = JSON.stringify(data);
        request.contentType = 'application/json';
    }

    if(functionSucces != null){
        request.success = functionSucces;
    }

    if(functionError != null){
        request.error = functionError;
    }
    $.ajax(request)
}

function getProducts() {
    let url = 'http://localhost:8080/products'

    sendRequest('GET', url, null, () => window.location.href='http://localhost:8080/products', null);
}
function getSales() {
    let url = 'http://localhost:8080/sales'
    sendRequest('GET', url, null, () => window.location.href='http://localhost:8080/sales', null);
}
function getManageProducts() {
    let url = 'http://localhost:8080/products/manage'

    sendRequest('GET', url, null, () => window.location.href='http://localhost:8080/products/manage', null);
}

function getMySales() {
    let url = 'http://localhost:8080/sales/mySales'

    sendRequest('GET', url, null, () => window.location.href='http://localhost:8080/sales/mySales', null);
}

function showMessage(message, success) {
    const classMessage = success ? "alert alert-success alert-dismissible fade show" : "alert alert-danger alert-dismissible fade show";

    const alert = $("<div>")
        .addClass(classMessage)
        .attr("role", "alert")
        .attr("id", "alertMessage")
        .html(message);

    const closeButton = $("<button>")
        .attr("type", "button")
        .addClass("close")
        .attr("data-dismiss", "alert")
        .attr("aria-label", "Close");

    closeButton.append('<span aria-hidden="true">&times;</span>');

    alert.append(closeButton);

    $("body").append(alert);
    setTimeout(() => {
        $(".alert").alert('close')
    }, 4000);
}