package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmDocumentos")
public class CMDocumentos {

	@Id
	private int idDocumento;
	
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private CMCentralMedica centralMedica;
	
	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="NOTIFICADO")
	private String notificado;
	
	@Column(name="RECIBIDO")
	private String recibido;
	
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
