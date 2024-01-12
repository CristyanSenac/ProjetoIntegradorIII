function sale(element){
    let product = $(element).closest('.colum-product');
    let id = product.find(".product-id").text()

    let url = 'http://localhost:8080/sale/' + id
    sendRequest('POST', url, null, 
    () => showMessage("Registramos o seu interesse no produto, em breve um de nossos consultores entrará em contato. Obrigado pela preferência!", true),
    () => showMessage("Ops, algo deu errado. Favor entrar em contato com o suporte!", false));
}
