package com.indicador.mapfre.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name = "XxmpfBpmCmSiniestros")
public class CMSiniestros {

	@Id
	private Long idSiniestro;
	
	@ManyToOne
	@MapsId("ID_SOLICITUD")
	@JoinColumn(name="ID_SOLICITUD",insertable = false, updatable = false)
	private CMCentralMedica centralMedica;
	
	/*@Column(name="ID_SOLICITUD")
	private Long idSolicitud;*/
	
	@OneToMany(mappedBy = "siniestro")
	@Cascade(CascadeType.ALL)
	private List<CMCpt> listCpt;
	
	@OneToMany(mappedBy = "siniestro")
	@Cascade(CascadeType.ALL)
	private List<CMHonorariosMed> listHonorarios;
	
	@OneToMany(mappedBy = "siniestro")
	@Cascade(CascadeType.ALL)
	private List<CMMedicamentos> listMedicamentos;
	
	@OneToMany(mappedBy = "siniestro")
	@Cascade(CascadeType.ALL)
	private List<CMServicios> listServicios;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="NUMERO_SINIESTRO")
	private Long numeroSiniestro;
	
	@Column(name="TIPO_SINIESTRO")
	private String tipoSiniestro;
	
	@Column(name="PORCENTAJE_EDO_CTA")
	private BigDecimal porcentajeEdoCta;
	
	@Column(name="MONTO_SINIESTRO")
	private Long montoSiniestro;
	
	@Column(name="FOLIO_RAM")
	private String folioRam;
	
	@Column(name="DESC_DIAGNOSTICO")
	private String descDiagnostico;
	
	@Column(name="COD_DIAGNOSTICO")
	private String codDiagnistico;
	
	@Column(name="FECHA_OCURRENCIA")
	private String fechaOcurrencia;
	
	@Column(name="CAUSA")
	private String causa;
	
	@Column(name="CONSECUENCIA")
	private String consecuencia;
	
	@Column(name="FECHA_INICIO_SINTOMAS")
	private String fechaInicioSintomas;
	
	@Column(name="COBERTURA_AFECTADA")
	private String coberturaAfectada;
	
	@Column(name="TIPO_PAGO")
	private String tipoPago;
	
	@Column(name="TIPO_RESERVA")
	private String tipoReserva;
	
	@Column(name="MONTO_RESERVA")
	private Long montoReserva;
	
	@Column(name="REMANENTE_SUMA_ASEG")
	private Long remanenteSumaAseg;
	
	@Column(name="TOTAL_AUTORIZADO_HM")
	private Long totalAutorizadoHm;
	
	@Column(name="FOLIO_RAM_MED")
	private String folioRamMed;
	
	@Column(name="CIUDAD_ENTREGA")
	private String ciudadEntrega;
	
	@Column(name="CODIGO_POSTAL_ENTREGA")
	private String codigoPostalEntrega;
	
	@Column(name="DIRECCION_ENTREGA")
	private String direccionEntrega;
	
	@Column(name="TEL_CONTACTO_ASEG")
	private String telContactoaseg;
	
	@Column(name="CORREO_NOTIF_ASEG")
	private String correoNotifAseg;
	
	@Column(name="TOTAL_AUTORIZADO_MED")
	private BigDecimal totalAutorizadoMed;
	
	@Column(name="FOLIO_RAM_SERV")
	private String folioRamServ;
	
	@Column(name="TOTAL_AUTORIZADO_SERV")
	private String totalAutorizadoServ;
	
	@Column(name="DEDUCIBLE_CONTRATADO")
	private Long deducibleContratado;
	
	@Column(name="REDUCCION_DEDUCIBLE")
	private Long reduccionDeducible;
	
	@Column(name="INCREMENTO_DEDUCIBLE")
	private Long incrementoDeducible;
	
	@Column(name="TOTAL_DEDUCIBLE")
	private Long totalDeducible;
	
	@Column(name="COASEGURO_CONTRATADO")
	private Long coaseguroContratado;
	
	@Column(name="RED_COASEGURO_HOSP")
	private Long redCoaSeguroHosp;
	
	@Column(name="INC_COASEGURO_HOSP")
	private Long incCoaseguroHosp;
	
	@Column(name="TOPE_COASEGURO")
	private Long topeCoaseguro;
	
	@Column(name="TIPO_TOPE_COASEGURO")
	private String tipoTopeCoaseguro;
	
	@Column(name="TOTAL_COASEGURO_HOSP")
	private Long totalCoaseguroHosp;
	
	@Column(name="COASEGURO_MEDICO")
	private Long coaseguroMedico;
	
	@Column(name="RED_COASEGURO_MED")
	private Long redCoaseguroMed;
	
	@Column(name="TOTAL_COASEGURO_MED")
	private Long totalCoaseguroMed;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdateBy;
	
	@Column(name="REDUCCION_COASEGURO_MED")
	private String reduccionCoaseguroMed;
	
	@Column(name="TOPE_INDEMNIZACION")
	private String topeIndemnizacion;
	
	@Column(name="TOTAL_DEDUCIBLE_MONTO")
	private String totalDeducibleMonto;
	
	@Column(name="DEDUCIBLE_MEDICAMENTOS")
	private String deducibleMedicamentos;
	
	@Column(name="COASEGURO_MEDICAMENTOS")
	private String coaseguroMedicamentos;
	
	@Column(name="TOTAL_MEDICAMENTOS")
	private String totalMedicamentos;
	
	@Column(name="DEDUCIBLE_SERVICIOS")
	private String deducibleServicios;
	
	@Column(name="COASEGURO_SERVICIOS")
	private String coaseguroServicios;
	
	@Column(name="TOTAL_SERVICIOS")
	private String totalServicios;

	public Long getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Long idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public CMCentralMedica getCentralMedica() {
		return centralMedica;
	}

	public void setCentralMedica(CMCentralMedica centralMedica) {
		this.centralMedica = centralMedica;
	}
	
	

	public List<CMCpt> getListCpt() {
		return listCpt;
	}

	/*public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}*/

	public void setListCpt(List<CMCpt> listCpt) {
		this.listCpt = listCpt;
	}

	public List<CMHonorariosMed> getListHonorarios() {
		return listHonorarios;
	}

	public void setListHonorarios(List<CMHonorariosMed> listHonorarios) {
		this.listHonorarios = listHonorarios;
	}

	public List<CMMedicamentos> getListMedicamentos() {
		return listMedicamentos;
	}

	public void setListMedicamentos(List<CMMedicamentos> listMedicamentos) {
		this.listMedicamentos = listMedicamentos;
	}

	public List<CMServicios> getListServicios() {
		return listServicios;
	}

	public void setListServicios(List<CMServicios> listServicios) {
		this.listServicios = listServicios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(Long numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getTipoSiniestro() {
		return tipoSiniestro;
	}

	public void setTipoSiniestro(String tipoSiniestro) {
		this.tipoSiniestro = tipoSiniestro;
	}

	public BigDecimal getPorcentajeEdoCta() {
		return porcentajeEdoCta;
	}

	public void setPorcentajeEdoCta(BigDecimal porcentajeEdoCta) {
		this.porcentajeEdoCta = porcentajeEdoCta;
	}

	public Long getMontoSiniestro() {
		return montoSiniestro;
	}

	public void setMontoSiniestro(Long montoSiniestro) {
		this.montoSiniestro = montoSiniestro;
	}

	public String getFolioRam() {
		return folioRam;
	}

	public void setFolioRam(String folioRam) {
		this.folioRam = folioRam;
	}

	public String getDescDiagnostico() {
		return descDiagnostico;
	}

	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}

	public String getCodDiagnistico() {
		return codDiagnistico;
	}

	public void setCodDiagnistico(String codDiagnistico) {
		this.codDiagnistico = codDiagnistico;
	}

	public String getFechaOcurrencia() {
		return fechaOcurrencia;
	}

	public void setFechaOcurrencia(String fechaOcurrencia) {
		this.fechaOcurrencia = fechaOcurrencia;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getConsecuencia() {
		return consecuencia;
	}

	public void setConsecuencia(String consecuencia) {
		this.consecuencia = consecuencia;
	}

	public String getFechaInicioSintomas() {
		return fechaInicioSintomas;
	}

	public void setFechaInicioSintomas(String fechaInicioSintomas) {
		this.fechaInicioSintomas = fechaInicioSintomas;
	}

	public String getCoberturaAfectada() {
		return coberturaAfectada;
	}

	public void setCoberturaAfectada(String coberturaAfectada) {
		this.coberturaAfectada = coberturaAfectada;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public Long getMontoReserva() {
		return montoReserva;
	}

	public void setMontoReserva(Long montoReserva) {
		this.montoReserva = montoReserva;
	}

	public Long getRemanenteSumaAseg() {
		return remanenteSumaAseg;
	}

	public void setRemanenteSumaAseg(Long remanenteSumaAseg) {
		this.remanenteSumaAseg = remanenteSumaAseg;
	}

	public Long getTotalAutorizadoHm() {
		return totalAutorizadoHm;
	}

	public void setTotalAutorizadoHm(Long totalAutorizadoHm) {
		this.totalAutorizadoHm = totalAutorizadoHm;
	}

	public String getFolioRamMed() {
		return folioRamMed;
	}

	public void setFolioRamMed(String folioRamMed) {
		this.folioRamMed = folioRamMed;
	}

	public String getCiudadEntrega() {
		return ciudadEntrega;
	}

	public void setCiudadEntrega(String ciudadEntrega) {
		this.ciudadEntrega = ciudadEntrega;
	}

	public String getCodigoPostalEntrega() {
		return codigoPostalEntrega;
	}

	public void setCodigoPostalEntrega(String codigoPostalEntrega) {
		this.codigoPostalEntrega = codigoPostalEntrega;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getTelContactoaseg() {
		return telContactoaseg;
	}

	public void setTelContactoaseg(String telContactoaseg) {
		this.telContactoaseg = telContactoaseg;
	}

	public String getCorreoNotifAseg() {
		return correoNotifAseg;
	}

	public void setCorreoNotifAseg(String correoNotifAseg) {
		this.correoNotifAseg = correoNotifAseg;
	}

	public BigDecimal getTotalAutorizadoMed() {
		return totalAutorizadoMed;
	}

	public void setTotalAutorizadoMed(BigDecimal totalAutorizadoMed) {
		this.totalAutorizadoMed = totalAutorizadoMed;
	}

	public String getFolioRamServ() {
		return folioRamServ;
	}

	public void setFolioRamServ(String folioRamServ) {
		this.folioRamServ = folioRamServ;
	}

	public String getTotalAutorizadoServ() {
		return totalAutorizadoServ;
	}

	public void setTotalAutorizadoServ(String totalAutorizadoServ) {
		this.totalAutorizadoServ = totalAutorizadoServ;
	}

	public Long getDeducibleContratado() {
		return deducibleContratado;
	}

	public void setDeducibleContratado(Long deducibleContratado) {
		this.deducibleContratado = deducibleContratado;
	}

	public Long getReduccionDeducible() {
		return reduccionDeducible;
	}

	public void setReduccionDeducible(Long reduccionDeducible) {
		this.reduccionDeducible = reduccionDeducible;
	}

	public Long getIncrementoDeducible() {
		return incrementoDeducible;
	}

	public void setIncrementoDeducible(Long incrementoDeducible) {
		this.incrementoDeducible = incrementoDeducible;
	}

	public Long getTotalDeducible() {
		return totalDeducible;
	}

	public void setTotalDeducible(Long totalDeducible) {
		this.totalDeducible = totalDeducible;
	}

	public Long getCoaseguroContratado() {
		return coaseguroContratado;
	}

	public void setCoaseguroContratado(Long coaseguroContratado) {
		this.coaseguroContratado = coaseguroContratado;
	}

	public Long getRedCoaSeguroHosp() {
		return redCoaSeguroHosp;
	}

	public void setRedCoaSeguroHosp(Long redCoaSeguroHosp) {
		this.redCoaSeguroHosp = redCoaSeguroHosp;
	}

	public Long getIncCoaseguroHosp() {
		return incCoaseguroHosp;
	}

	public void setIncCoaseguroHosp(Long incCoaseguroHosp) {
		this.incCoaseguroHosp = incCoaseguroHosp;
	}

	public Long getTopeCoaseguro() {
		return topeCoaseguro;
	}

	public void setTopeCoaseguro(Long topeCoaseguro) {
		this.topeCoaseguro = topeCoaseguro;
	}

	public String getTipoTopeCoaseguro() {
		return tipoTopeCoaseguro;
	}

	public void setTipoTopeCoaseguro(String tipoTopeCoaseguro) {
		this.tipoTopeCoaseguro = tipoTopeCoaseguro;
	}

	public Long getTotalCoaseguroHosp() {
		return totalCoaseguroHosp;
	}

	public void setTotalCoaseguroHosp(Long totalCoaseguroHosp) {
		this.totalCoaseguroHosp = totalCoaseguroHosp;
	}

	public Long getCoaseguroMedico() {
		return coaseguroMedico;
	}

	public void setCoaseguroMedico(Long coaseguroMedico) {
		this.coaseguroMedico = coaseguroMedico;
	}

	public Long getRedCoaseguroMed() {
		return redCoaseguroMed;
	}

	public void setRedCoaseguroMed(Long redCoaseguroMed) {
		this.redCoaseguroMed = redCoaseguroMed;
	}

	public Long getTotalCoaseguroMed() {
		return totalCoaseguroMed;
	}

	public void setTotalCoaseguroMed(Long totalCoaseguroMed) {
		this.totalCoaseguroMed = totalCoaseguroMed;
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

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getReduccionCoaseguroMed() {
		return reduccionCoaseguroMed;
	}

	public void setReduccionCoaseguroMed(String reduccionCoaseguroMed) {
		this.reduccionCoaseguroMed = reduccionCoaseguroMed;
	}

	public String getTopeIndemnizacion() {
		return topeIndemnizacion;
	}

	public void setTopeIndemnizacion(String topeIndemnizacion) {
		this.topeIndemnizacion = topeIndemnizacion;
	}

	public String getTotalDeducibleMonto() {
		return totalDeducibleMonto;
	}

	public void setTotalDeducibleMonto(String totalDeducibleMonto) {
		this.totalDeducibleMonto = totalDeducibleMonto;
	}

	public String getDeducibleMedicamentos() {
		return deducibleMedicamentos;
	}

	public void setDeducibleMedicamentos(String deducibleMedicamentos) {
		this.deducibleMedicamentos = deducibleMedicamentos;
	}

	public String getCoaseguroMedicamentos() {
		return coaseguroMedicamentos;
	}

	public void setCoaseguroMedicamentos(String coaseguroMedicamentos) {
		this.coaseguroMedicamentos = coaseguroMedicamentos;
	}

	public String getTotalMedicamentos() {
		return totalMedicamentos;
	}

	public void setTotalMedicamentos(String totalMedicamentos) {
		this.totalMedicamentos = totalMedicamentos;
	}

	public String getDeducibleServicios() {
		return deducibleServicios;
	}

	public void setDeducibleServicios(String deducibleServicios) {
		this.deducibleServicios = deducibleServicios;
	}

	public String getCoaseguroServicios() {
		return coaseguroServicios;
	}

	public void setCoaseguroServicios(String coaseguroServicios) {
		this.coaseguroServicios = coaseguroServicios;
	}

	public String getTotalServicios() {
		return totalServicios;
	}

	public void setTotalServicios(String totalServicios) {
		this.totalServicios = totalServicios;
	}
	
	
}
