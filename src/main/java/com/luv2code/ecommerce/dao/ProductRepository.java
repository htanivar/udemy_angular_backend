package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = {"http://localhost:4200","http://devnath.ddns.net:2200"})
public interface ProductRepository extends JpaRepository<Product, Long> {

}
