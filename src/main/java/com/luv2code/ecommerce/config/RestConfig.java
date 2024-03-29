package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class RestConfig  implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    public RestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupporedMethods = {HttpMethod.POST,HttpMethod.DELETE,HttpMethod.PUT};
                config.getExposureConfiguration()
                        .forDomainType(Product.class)
                        .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupporedMethods)))
                        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupporedMethods));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupporedMethods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupporedMethods));
//        call an internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

//        get a list of all entity classes from the entity entityManager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

//        create an arrya of the entity types
        List<Class> entityClasses = new ArrayList<>();

//        get the entity types for the entities
        for (EntityType tempEntityType: entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

//        expose the entity ids for the array of enitty/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }


}
