//Variables
const carrito = document.querySelector('#carrito');
const contenedorCarrito = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.querySelector('#vaciar-carrito');
const procesarCompraBtn = document.querySelector('#procesar-compra')
const listaProductos = document.querySelector('#lista-productos');
let articulosCarrito = [];

cargarEventListeners();
function cargarEventListeners() {
    //Cuando agregas un curso presionando "Agregar al Carrito"
    listaProductos.addEventListener('click', agregarProducto);

    //Elimina cursos del carrito
    carrito.addEventListener('click', eliminarProducto);

    //Muestra los productos de Local Storage
    document.addEventListener('DOMContentLoaded', () =>  {
        articulosCarrito = JSON.parse( localStorage.getItem('carrito') ) || [];

        carritoHTML();
    })

    //Vaciar el carrito
    vaciarCarritoBtn.addEventListener('click', () => {
        articulosCarrito = []; //reseteamos el arreglo

        limpiarHTML(); //Eliminamos todo el HTML
    })
}


//Funciones
function agregarProducto(e) {
    e.preventDefault();

    if(e.target.classList.contains('btn')) {
        console.log(e.target, "target")
        const productoSeleccionado = e.target.parentElement;
        leerDatosProducto(productoSeleccionado);
    }

}

//Elimina el producto del carrito
function eliminarProducto(e) {
    //console.log(e.target.classList);
    if(e.target.classList.contains('borrar-producto')) {
        const productoId = e.target.getAttribute('data-id');

        //Elimina del arreglo
        articulosCarrito = articulosCarrito.filter( producto => producto.id !== productoId );

        carritoHTML(); //Iterar sobre el carrito y mostrar su HTML
    }
}

//Leer el contenido del HTML al que le dimos clic y extrae la información del producto
function leerDatosProducto(producto) {
    //console.log(producto);

    //Crear un objeto con el contenido del curso actual
    const infoProducto = {
        imagen: producto.querySelector('img').src,
        titulo: producto.querySelector('h3').textContent,
        precio: producto.querySelector('.price span').textContent,
        id: producto.querySelector('.buy').getAttribute('data-id'),
        cantidad: parseInt(producto.querySelector('input').value),
    }

    console.log(infoProducto);
    //Revisa si un elemento ya existe en el carrito
    const existe = articulosCarrito.some( producto => producto.id === infoProducto.id );
    if (existe) {
        //Actualizamos la cantidad
        const productos = articulosCarrito.map( producto => {
            if ( producto.id === infoProducto.id ){
                producto.cantidad += infoProducto.cantidad;
                return producto; //Retorna el objeto actualizado
            }else{
                return producto; //Retorna los objetos que no son duplicados
            }
        } );
        articulosCarrito = [...productos];
    } else {
        //Agrega elementos al arreglo de carrito
        articulosCarrito = [...articulosCarrito, infoProducto];
    }



    console.log(articulosCarrito);

    carritoHTML();
}


//Muestra el carrito de compras en el HTML
function carritoHTML() {

    //Limpiar el HTML
    limpiarHTML();


    //Recorre el carrito y genera el HTML
    articulosCarrito.forEach( producto => {
        const { imagen, titulo, precio, cantidad, id} = producto;
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${imagen}" width="100" alt="que pedo vago">
            </td>
            <td>${titulo}</td>
            <td>${precio}</td>
            <td>${cantidad}</td>
            <td>
                <a href="#" class="borrar-producto" data-id="${id}" style="color: red;" > X </a>
            </td>
        `;

        //Agrega el HTML del carrito en el tbody
        contenedorCarrito.appendChild(row);
    })

    // Agregar el carrito de compras al storage
    sincronizarStorage();
}

function sincronizarStorage() {
    localStorage.setItem('carrito', JSON.stringify(articulosCarrito));
}

//Elimina los cursos del tbody
function limpiarHTML() {
    //Forma lenta
    //contenedorCarrito.innerHTML = '';


    while(contenedorCarrito.firstChild) {
        contenedorCarrito.removeChild(contenedorCarrito.firstChild)
    }
}
