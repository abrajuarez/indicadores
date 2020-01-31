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
	private Long idSolicitud;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	public Long getIdRegProceso() {
		return idRegProceso;
	}

	public void setIdRegProceso(Long idRegProceso) {
		this.idRegProceso = idRegProceso;
	}

	public List<CMBitacora> getListBitacora() {
		return listBitacora;
	}

	public void setListBitacora(List<CMBitacora> listBitacora) {
		this.listBitacora = listBitacora;
	}

	public List<CMComentProc> getListComentProc() {
		return listComentProc;
	}

	public void setListComentProc(List<CMComentProc> listComentProc) {
		this.listComentProc = listComentProc;
	}

	public int getCodSector() {
		return codSector;
	}

	public void setCodSector(int codSector) {
		this.codSector = codSector;
	}

	public int getCodProceso() {
		return codProceso;
	}

	public void setCodProceso(int codProceso) {
		this.codProceso = codProceso;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
}
