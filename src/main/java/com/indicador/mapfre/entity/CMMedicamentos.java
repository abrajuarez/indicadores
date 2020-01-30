package com.indicador.mapfre.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmMedicamentos")
public class CMMedicamentos {

	@Id
	private int idMedicamento;
	//ID_SINIESTRO
	@ManyToOne
	@JoinColumn(name = "siniestro")
	CMSiniestros siniestro;
	
	@Column(name="PROVEEDOR")
	private String proveedor;
	
	@Column(name="CODIGO_MEDICAMENTO")
	private String codigoMedicamento;
	
	@Column(name="DESCRIPCION_MEDICAMENTO")
	private String descripcionMedicamento;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	@Column(name="PRECIO_AUT_UNIDAD")
	private BigDecimal precioAutUnidad; 
	
	@Column(name="TOTAL_AUTORIZADO")
	private BigDecimal totalAutorizado;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdateBy;
	
	@Column(name="INDICE_PROVIDER")
	private String indiceProvider;
}
