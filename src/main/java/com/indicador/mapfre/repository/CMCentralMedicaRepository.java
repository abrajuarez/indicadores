package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.indicador.mapfre.entity.CMCentralMedica;


@Repository
public interface CMCentralMedicaRepository extends JpaRepository<CMCentralMedica, Long>{

	static final String REPORTQUERY = "SELECT cm"
            + " FROM CMCentralMedica cm,"
            + " CMSiniestros sin,"
            + " CMDocumentos doc,"
            + " CMSdaValoracion valoracion,"
            + " CMHonorariosMed honorariosmd,"
            + " CMMedicamentos medicamento,"
            + " CMServicios servicio,"
            + " CMCpt cpt "
            + " WHERE cm.idSolicitud = sin.centralMedica"
            + " AND cm.idSolicitud = doc.centralMedica"
            + " AND cm.idSolicitud = valoracion.centralMedica "
            + " AND sin.idSiniestro = honorariosmd.siniestro"
            + " AND sin.idSiniestro = medicamento.siniestro"
            + " AND sin.idSiniestro = servicio.siniestro"
            + " AND sin.idSiniestro = cpt.siniestro"
            + " AND cm.creationDate >= :dateStart"
            + " AND cm.creationDate <= :dateFinish";
	
	
	@Query(REPORTQUERY)
	List<CMCentralMedica> findByCreationDate(@Param("dateStart")String dateStart,@Param("dateFinish") String dateFinish);

	@Query("SELECT cm FROM CMCentralMedica cm WHERE cm.creationDate >= :dateStart AND cm.creationDate <= :dateFinish")
	List<CMCentralMedica> findByCreation(@Param("dateStart")String dateStart,@Param("dateFinish") String dateFinish);

}
