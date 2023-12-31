package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var categorias = categoriaDao.findAll();
        //Si son solo activas (activo = true) debo filtrar las inactivas...
        if (activo) {
            categorias.removeIf(e -> !e.isActivo());
        }
        return categorias;
    }

    //Se obtiene una Categoría según el Id pasado por parámetro
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    //Se actualiza una categoria o se inserta una nueva..(Si no hay id es un insert)
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    //Se elimina una categoria segun el id pasado 
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
