function updateInventory(productId, action, actual) {
    let url = 'http://localhost:8080/product/updateinventory/' + productId + '?action=' + action;
    sendRequest('PUT', url, null, () => updateInventoryTemp(productId, action, actual), () => showMessage("Ops, algo deu errado. Favor entrar em contato com o suporte!", false));
}

function updateInventoryTemp(productId, action, actual){
    var newInventoryValue;
    if (action === 'increase') {
        newInventoryValue = actual + 1;
    } else if (action === 'decrease' && actual > 0) {
        newInventoryValue = actual - 1;
    } else {
        newInventoryValue = actual;
    }

    $('#inventory-' + productId).text(newInventoryValue);
}

function deleteProduct(productId) {
    let url = 'http://localhost:8080/product/delete/' + productId;

    sendRequest('DELETE', url, null, () => removeProductRow(productId), () => showMessage("Erro ao deletar o produto", false));
}

function removeProductRow(productId) {
    $('#row-' + productId).remove();
}

$(document).ready(() => {
    $("#createProductForm").submit(e => {
        e.preventDefault();

        let product = {};
        product.name = $("#productName").val();
        product.description = $("#productDescription").val();
        product.inventory = parseInt($("#productInventory").val().split(/[.,]/)[0]);
        product.price = parseFloat($("#productPrice").val());
        product.typeId = parseInt($("#productType").val());

        if (!isValidFields(product.name, product.description, product.inventory, product.price, product.typeId)) {
            return;
        }


        sendRequest('POST', 'http://localhost:8080/product', product,() => {
            showMessage("Sucesso ao cadastrar o produto", true);
        
            setTimeout(function () {
                window.location.href = '/products/manage';
            }, 2000);
        }, () => showMessage("Erro ao cadastrar o produto", false));

        $('#createProductModal').modal('hide');
    });
});