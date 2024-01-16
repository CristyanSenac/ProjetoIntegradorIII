$(document).ready(() => {
    $("#login-form").submit(e => {
        e.preventDefault();

        let data = {};

        data.login = $("#input-login").val();
        data.password = $("#input-password").val();

        if(!isValidFields(data.login, data.password)){
            return;
        }

        let url = 'http://localhost:8080/signin'

        sendRequest('POST', url, data, () => window.location.href='http://localhost:8080/home', () => showMessage("Dados de login inválidos", false));
    })
})


$("#login-form").validate({
    rules: {
        login: {
            required: true
        },
        password: {
            required: true
        }
    },
    messages: {
        login: {
            required: "Favor preencher o login"
        },
        password: {
            required: "Favor preencher a senha",
        }
    }
});