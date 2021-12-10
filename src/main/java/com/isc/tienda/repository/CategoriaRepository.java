package com.isc.tienda.repository;

import com.isc.tienda.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query(value = "Select c From Categoria c where c.estado = ?1")
    List<Categoria> listCategorias(String estado);

    @Query(value = "call listar_Categorias(:estado_in);", nativeQuery = true)
    List<Categoria> listCategoriasEstado(@Param("estado_in") String estado_in);
}
