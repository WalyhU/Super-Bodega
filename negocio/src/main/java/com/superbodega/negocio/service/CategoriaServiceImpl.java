package com.superbodega.negocio.service;

import com.superbodega.negocio.entity.Categoria;
import com.superbodega.negocio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void updateCategoria(Long id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.updateCategoria(id, categoria.getNombre());
        } else {
            throw new IllegalArgumentException("Categoria no encontrada");
        }
    }

    @Override
    public void deleteCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Categoria no encontrada");
        }
    }
}
