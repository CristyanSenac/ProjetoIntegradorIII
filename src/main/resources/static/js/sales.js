function cancelSale(saleId){
    let url = 'http://localhost:8080/sale/' + saleId
    
    sendRequest('DELETE', url, null,() => {
        showMessage("Sucesso ao cancelar a compra", true);
    
        setTimeout(function () {
            window.location.href = '/sales/mySales';
        }, 2000);
    }, () => showMessage("Erro ao cancelar a compra", false));
}
