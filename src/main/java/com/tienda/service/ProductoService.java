package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //Se obtiene un array List con todas las productos de la tabla
    public List<Producto> getProductos(boolean activo);
    
    //Se obtiene una Categoría según el Id pasado por parámetro
    public Producto getProducto(Producto producto);
    
    //Se actualiza una producto o se inserta una nueva..(Si no hay id es un insert)
    public void save(Producto producto);
    
    //Se elimina una producto segun el id pasado 
    public void delete(Producto producto);
}
