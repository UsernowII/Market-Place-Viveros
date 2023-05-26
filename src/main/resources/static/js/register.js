async function register(){

    let datos = {};
    datos.userName =  document.getElementById("txtName").value;
    datos.lastName =  document.getElementById("txtLastName").value;
    datos.phone =  document.getElementById("txtPhone").value;
    datos.email =  document.getElementById("txtEmail").value;
    datos.password =  document.getElementById("txtPassword").value;

    let repeatPassword = document.getElementById("txtRepeatPassword").value;


    if( repeatPassword !== datos.password) {
        alert("Las contraseñas no coinciden")
        return;
    }

    const request = await fetch("/api/register", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body : JSON.stringify(datos)
    })



    alert("Cuenta Creada exitosamente");
    window.location.href = "index.html";
}