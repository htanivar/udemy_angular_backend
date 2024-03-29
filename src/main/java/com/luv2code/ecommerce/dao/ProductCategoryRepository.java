package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@Repository
@CrossOrigin(origins = {"http://localhost:4200", "http://devnath.ddns.net:2200"})
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
