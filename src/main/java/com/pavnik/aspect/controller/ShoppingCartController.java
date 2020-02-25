/**
 * 
 */
package com.pavnik.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pavnik.aspect.aop.ShoppingLoggable;
import com.pavnik.aspect.aop.repository.CatalogItemsRepository;
import com.pavnik.aspect.model.CatalogItems;
import com.pavnik.aspectexception.ItemNotFoundException;

/**
 * @author pavni
 *
 */
@RestController
public class ShoppingCartController {

	@Autowired
	private CatalogItemsRepository catalogItemsRepository;

	@ShoppingLoggable 
	@GetMapping("/items")
	public Iterable<CatalogItems> getItems()
	{
		return catalogItemsRepository.findAll();
	}
	
	@ShoppingLoggable 
	@GetMapping("/items/{id}")
	public CatalogItems getItems( @PathVariable Long id) throws ItemNotFoundException
	{
		return catalogItemsRepository.findById(id).orElseThrow(
				()-> new ItemNotFoundException("Item not found for id ::" + id)
				);
	}
	
}
