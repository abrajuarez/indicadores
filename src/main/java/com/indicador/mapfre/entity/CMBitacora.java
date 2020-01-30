package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmBitacora")
public class CMBitacora {

	@Id
	private Long idBitacora;
	
	//ID_REG_PROCESO
	@ManyToOne
	@JoinColumn(name="ID_REG_PROCESO")
	CMRegProceso regProceso;
	
	@Column(name="COD_SECTOR")
	private int codSector;
	
	@Column(name="NOMBRE_PROCESO")
	private String nombreProceso;
	
	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;
	
	@Column(name="FECHA_INICIO_ACTIVIDAD")
	private String fechaInicioActividad;
	
	@Column(name="FECHA_FIN_ACTIVIDAD")
	private String fechaFinActividad;
	
	@Column(name="CLAVE_ESTATUS")
	private String claveEstatus;
	
	@Column(name="SECUENCIA")
	private String secuencia;
	
	@Column(name="USUARIO_EJECUTO")
	private String usuarioEjecutivo;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
}
