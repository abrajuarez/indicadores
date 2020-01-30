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



@Entity
@Table(name = "XxmpfBpmCmSiniestros")
public class CMSiniestros {

	@Id
	private int idSiniestro;
	
	@ManyToOne
	@MapsId("ID_SOLICITUD")
	@JoinColumn(name="ID_SOLICITUD",insertable = false, updatable = false)
	private CMCentralMedica centralMedica;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMCpt> listCpt;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMHonorariosMed> listHonorarios;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMMedicamentos> listMedicamentos;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMServicios> listServicios;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="NUMERO_SINIESTRO")
	private int numeroSiniestro;
	
	@Column(name="TIPO_SINIESTRO")
	private String tipoSiniestro;
	
	@Column(name="PORCENTAJE_EDO_CTA")
	private int porcentajeEdoCta;
	
	@Column(name="MONTO_SINIESTRO")
	private int montoSiniestro;
	
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
	private int montoReserva;
	
	@Column(name="REMANENTE_SUMA_ASEG")
	private int remanenteSumaAseg;
	
	@Column(name="TOTAL_AUTORIZADO_HM")
	private int totalAutorizadoHm;
	
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
	private int deducibleContratado;
	
	@Column(name="REDUCCION_DEDUCIBLE")
	private int reduccionDeducible;
	
	@Column(name="INCREMENTO_DEDUCIBLE")
	private int incrementoDeducible;
	
	@Column(name="TOTAL_DEDUCIBLE")
	private int totalDeducible;
	
	@Column(name="COASEGURO_CONTRATADO")
	private int coaseguroContratado;
	
	@Column(name="RED_COASEGURO_HOSP")
	private int redCoaSeguroHosp;
	
	@Column(name="INC_COASEGURO_HOSP")
	private int incCoaseguroHosp;
	
	@Column(name="TOPE_COASEGURO")
	private int topeCoaseguro;
	
	@Column(name="TIPO_TOPE_COASEGURO")
	private String tipoTopeCoaseguro;
	
	@Column(name="TOTAL_COASEGURO_HOSP")
	private int totalCoaseguroHosp;
	
	@Column(name="COASEGURO_MEDICO")
	private int coaseguroMedico;
	
	@Column(name="RED_COASEGURO_MED")
	private int redCoaseguroMed;
	
	@Column(name="TOTAL_COASEGURO_MED")
	private int totalCoaseguroMed;
	
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

	public int getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(int idSiniestro) {
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

	public int getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(int numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getTipoSiniestro() {
		return tipoSiniestro;
	}

	public void setTipoSiniestro(String tipoSiniestro) {
		this.tipoSiniestro = tipoSiniestro;
	}

	public int getPorcentajeEdoCta() {
		return porcentajeEdoCta;
	}

	public void setPorcentajeEdoCta(int porcentajeEdoCta) {
		this.porcentajeEdoCta = porcentajeEdoCta;
	}

	public int getMontoSiniestro() {
		return montoSiniestro;
	}

	public void setMontoSiniestro(int montoSiniestro) {
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

	public int getMontoReserva() {
		return montoReserva;
	}

	public void setMontoReserva(int montoReserva) {
		this.montoReserva = montoReserva;
	}

	public int getRemanenteSumaAseg() {
		return remanenteSumaAseg;
	}

	public void setRemanenteSumaAseg(int remanenteSumaAseg) {
		this.remanenteSumaAseg = remanenteSumaAseg;
	}

	public int getTotalAutorizadoHm() {
		return totalAutorizadoHm;
	}

	public void setTotalAutorizadoHm(int totalAutorizadoHm) {
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

	public int getDeducibleContratado() {
		return deducibleContratado;
	}

	public void setDeducibleContratado(int deducibleContratado) {
		this.deducibleContratado = deducibleContratado;
	}

	public int getReduccionDeducible() {
		return reduccionDeducible;
	}

	public void setReduccionDeducible(int reduccionDeducible) {
		this.reduccionDeducible = reduccionDeducible;
	}

	public int getIncrementoDeducible() {
		return incrementoDeducible;
	}

	public void setIncrementoDeducible(int incrementoDeducible) {
		this.incrementoDeducible = incrementoDeducible;
	}

	public int getTotalDeducible() {
		return totalDeducible;
	}

	public void setTotalDeducible(int totalDeducible) {
		this.totalDeducible = totalDeducible;
	}

	public int getCoaseguroContratado() {
		return coaseguroContratado;
	}

	public void setCoaseguroContratado(int coaseguroContratado) {
		this.coaseguroContratado = coaseguroContratado;
	}

	public int getRedCoaSeguroHosp() {
		return redCoaSeguroHosp;
	}

	public void setRedCoaSeguroHosp(int redCoaSeguroHosp) {
		this.redCoaSeguroHosp = redCoaSeguroHosp;
	}

	public int getIncCoaseguroHosp() {
		return incCoaseguroHosp;
	}

	public void setIncCoaseguroHosp(int incCoaseguroHosp) {
		this.incCoaseguroHosp = incCoaseguroHosp;
	}

	public int getTopeCoaseguro() {
		return topeCoaseguro;
	}

	public void setTopeCoaseguro(int topeCoaseguro) {
		this.topeCoaseguro = topeCoaseguro;
	}

	public String getTipoTopeCoaseguro() {
		return tipoTopeCoaseguro;
	}

	public void setTipoTopeCoaseguro(String tipoTopeCoaseguro) {
		this.tipoTopeCoaseguro = tipoTopeCoaseguro;
	}

	public int getTotalCoaseguroHosp() {
		return totalCoaseguroHosp;
	}

	public void setTotalCoaseguroHosp(int totalCoaseguroHosp) {
		this.totalCoaseguroHosp = totalCoaseguroHosp;
	}

	public int getCoaseguroMedico() {
		return coaseguroMedico;
	}

	public void setCoaseguroMedico(int coaseguroMedico) {
		this.coaseguroMedico = coaseguroMedico;
	}

	public int getRedCoaseguroMed() {
		return redCoaseguroMed;
	}

	public void setRedCoaseguroMed(int redCoaseguroMed) {
		this.redCoaseguroMed = redCoaseguroMed;
	}

	public int getTotalCoaseguroMed() {
		return totalCoaseguroMed;
	}

	public void setTotalCoaseguroMed(int totalCoaseguroMed) {
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
