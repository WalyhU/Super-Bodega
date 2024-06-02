package com.superbodega.ecommerce.repository;

import com.superbodega.ecommerce.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoRepository extends PagingAndSortingRepository<Producto,Long>, JpaSpecificationExecutor<Producto> {
    Page<Producto> findByCategoriaNombre(String categoriaNombre, Pageable pageable);
}