package com.isc.tienda.service;

import com.isc.tienda.model.Categoria;
import com.isc.tienda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Categoria categoria){
        Categoria auxCategoria= categoriaRepository.findById(categoria.getId()).orElse(null);
        if(auxCategoria != null){
            return categoriaRepository.save(categoria);
        }else{
            return null;
        }
    }

    public boolean deleteCategoria(int idCategoria){
        Categoria auxCategoria= categoriaRepository.findById(idCategoria).orElse(null);
        if(auxCategoria != null){
            categoriaRepository.delete(auxCategoria);
            return true;
        }else{
            return false;
        }
    }

    public List<Categoria> listarCategorias(String estado){
        return categoriaRepository.listCategoriasEstado(estado);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
