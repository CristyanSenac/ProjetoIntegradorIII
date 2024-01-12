function updateInventory(productId, action, actual) {
    let url = 'http://localhost:8080/product/updateinventory/' + productId + '?action=' + action + '&actual=' + actual;

    sendRequest('PUT', url, null, () => updateInventoryTemp(productId, action), () => showMessage("Ops, algo deu errado. Favor entrar em contato com o suporte!", false));
}

function updateInventoryTemp(productId,action){
    var currentInventory = parseInt($('#inventory-' + productId).text());
    var newInventoryValue;

    if (action === 'increase') {
        newInventoryValue = currentInventory + 1;
    } else if (action === 'decrease' && currentInventory > 0) {
        newInventoryValue = currentInventory - 1;
    } else {
        newInventoryValue = currentInventory;
    }

    $('#inventory-' + productId).text(newInventoryValue);
}

function deleteProduct(productId) {
    let url = 'http://localhost:8080/product/delete/' + productId;

    sendRequest('DELETE', url, null, () => removeProductRow(productId), null);
}

function removeProductRow(productId) {
    console.log("Entrando na remoção")
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