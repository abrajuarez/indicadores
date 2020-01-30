package com.indicador.mapfre.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmRegProceso")
public class CMRegProceso {

	@Id
	private Long idRegProceso;
	
	@OneToMany(mappedBy = "regProceso")
	private List<CMBitacora>listBitacora;
	
	@OneToMany(mappedBy = "regProceso")
	private List<CMComentProc>listComentProc;
	
	@Column(name="COD_SECTOR")
	private int codSector;
	
	@Column(name="COD_PROCESO")
	private int codProceso;
	
	@Column(name="ID_SOLICITUD")
	private int idSolicitud;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
}
