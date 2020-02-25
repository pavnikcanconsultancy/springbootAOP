package com.pavnik.aspect.aop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pavnik.aspect.model.CatalogItems;

@Repository
public interface CatalogItemsRepository extends CrudRepository<CatalogItems, Long>{

}
