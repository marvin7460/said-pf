package com.example.ferreteria.repository;
import com.example.ferreteria.model.ProductModel
        ;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
