package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IProductoService;
import tec.qa.veterinaria.interfaces.IProducto;
import tec.qa.veterinaria.model.Producto;

import java.util.List;
import java.util.Optional;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Service
public class ProductoService implements IProductoService {

    //Inyección de dependencias
    @Autowired
    private IProducto data;

    /*
    Parametros: N/A
    Retorno: Lista de productos
    Descripción: Método que retorna una lista de productos
     */
    @Override
    public List<Producto> listar() {

        return (List<Producto>)data.findAll();
    }

    /*
    Parametros: Id
    Retorno: Producto
    Descripción: Método que retorna un producto por Id
     */
    @Override
    public Optional<Producto> listarId(int id) {
        return data.findById(id);
    }

    /*
    Parametros: Producto
    Retorno: Boolean
    Descripción: Método que guarda un producto
     */
    @Override
    public boolean save(Producto p) {

        try {
            if (p != null) {
                Producto producto = data.save(p);
                if (producto != null){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Parametros: Id
    Retorno: Boolean
    Descripción: Método que elimina un producto por Id
     */
    @Override
    public boolean delete(int id) {
        try {
            if (data.existsById(id)) {
                data.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}