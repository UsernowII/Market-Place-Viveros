async function login() {
    console.log("login");
    let datos = {};
    datos.email = document.querySelector('#txtEmail').value;
    datos.password = document.querySelector('#txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const tokenResponse = await request.text();

    if ( tokenResponse.length > 100 && !tokenResponse.toLocaleLowerCase().includes("no")) {
        localStorage.token = tokenResponse;
        localStorage.email = datos.email;
        return window.location.href = "index.html";
    }

    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");

}