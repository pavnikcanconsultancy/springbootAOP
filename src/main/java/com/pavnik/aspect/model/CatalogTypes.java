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

@Entity
@Table( name="CTG_TYPES")
@Getter @Setter @EqualsAndHashCode
public class CatalogTypes {

	@Id
	@GeneratedValue( strategy =  GenerationType.AUTO)
	@Column( name="CTGTYP_ID", nullable = false, unique = true)
	private Long id;
	
	@Column( name ="CTGTYP_NAME", length = 50, nullable = false, unique = true)
	private String name;

}
