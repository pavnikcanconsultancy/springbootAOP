/**
 * 
 */
package com.pavnik.aspect.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pavni
 *
 */
@Entity
@Table( name = "CTG_ITEMS")
@Getter @Setter @EqualsAndHashCode
public class CatalogItems {

	@Id
	@GeneratedValue( strategy =  GenerationType.AUTO)
	@Column( name = "CTGITM_ID", unique = true, nullable = false)
	private Long id;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn( name = "CTGITM_CATID", referencedColumnName = "CTGTYP_ID", nullable = false)
	private CatalogTypes catalogTypes;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn( name = "CTGITM_BRDID", referencedColumnName = "CTGBRD_ID", nullable = false)
	private CatalogBrands catalogBrands;
	
	@Column( name ="CTGITM_DESCRIPTION", length = 35, nullable = true)
	private String description;
	
	@Column( name ="CTGITM_NAME", length = 50, nullable = false)
	private String name;
	
	@Column( name ="CTGITM_PRICE", length = 14, precision = 2)
	private double price;
	
	@Column( name ="CTGITM_IMG", length = 25, nullable = true)
	private String imgName;
	
	@Column( name ="CTGITM_AVLSTK", length = 10, precision = 0)
	private long availableStock;
	
	@Column( name ="CTGITM_STKSTATUS", length = 1)
	private boolean reorder;
	
}
