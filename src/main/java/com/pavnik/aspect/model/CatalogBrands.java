/**
 * 
 */
package com.pavnik.aspect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pavni
 *
 */
@Entity
@Table( name ="CTG_BRANDS")
@Getter @Setter @EqualsAndHashCode
public class CatalogBrands 
{

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "CTGBRD_ID", unique = true, nullable = false)
	private Long id;
	
	@Column( name = "CTGBRD_NAME",length = 50, unique = true, nullable = false)
	private String name;

}
