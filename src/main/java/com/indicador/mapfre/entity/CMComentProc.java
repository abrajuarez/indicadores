package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmComentProc")
public class CMComentProc {

	@Id
	private Long idBitacora;
	
	//ID_REG_PROCESO
	@ManyToOne
	@JoinColumn(name="ID_REG_PROCESO")
	CMRegProceso regProceso;
	
	@Column(name="COMENTARIO")
	private String comentario;
	
	@Column(name="FECHA_COMENTARIO")
	private String fechaComentario;
	
	@Column(name="NOMBRE_PROCESO")
	private String  nombreProceso;
	
	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;
	
	@Column(name="SECUENCIA")
	private int secuencia;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
}
