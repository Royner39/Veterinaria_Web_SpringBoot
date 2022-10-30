function eliminarCliente(cedula){
    swal({
        title: "Está seguro que desea eliminar este cliente?",
        text: "Una vez eliminado, no podrá recuperar la información relacionada!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax(
                    {url:"/eliminarCliente/"+cedula,
                        success: function (res){
                            console.log(res);
                        }});
                swal("Poof! El cliente se ha eliminado correctamente!", {
                    icon: "success",
                }).then((OK)=>{
                    location.href="/listarClientes";
                });
            } else {
                swal("No se ha eliminado el cliente!");
            }
        });
}
function eliminarMascota(id_mascota, cedula_cliente) {
    swal({
        title: "Está seguro que desea eliminar esta mascota?",
        text: "Una vez eliminada, no podrá recuperar la información relacionada!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax(
                    {
                        url: "/eliminarMascota/" + id_mascota,
                        success: function (res) {
                            console.log(res);
                        }
                    });
                swal("Poof! La mascota se ha eliminado correctamente!", {
                    icon: "success",
                }).then((OK) => {
                    location.href = "/listarMascotas/"+cedula_cliente;
                });
            } else {
                swal("No se ha eliminado la mascota!");
            }
        });
}
function eliminarMedico(id_medico){
    swal({
        title: "Está seguro que desea eliminar este médico?",
        text: "Una vez eliminado, no podrá recuperar la información relacionada!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax(
                    {url:"/eliminarMedico/"+id_medico,
                        success: function (res){
                            console.log(res);
                        }});
                swal("Poof! El médico se ha eliminado correctamente!", {
                    icon: "success",
                }).then((OK)=>{
                    location.href="/listarMedicos";
                });
            } else {
                swal("No se ha eliminado el médico!");
            }
        });
}
function eliminarProducto(id_producto){
    swal({
        title: "Está seguro que desea eliminar este producto?",
        text: "Una vez eliminado, no podrá recuperar la información relacionada!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax(
                    {url:"/eliminarProducto/"+id_producto,
                        success: function (res){
                            console.log(res);
                        }});
                swal("Poof! El producto se ha eliminado correctamente!", {
                    icon: "success",
                }).then((OK)=>{
                    location.href="/listarProductos";
                });
            } else {
                swal("No se ha eliminado el médico!");
            }
        });
}
