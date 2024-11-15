package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Categoria getCategoriaById(Long id);
    Categoria saveCategoria(Categoria categoria);
    void updateCategoria(Long id, Categoria categoria);
    void deleteCategoria(Long id);
}
