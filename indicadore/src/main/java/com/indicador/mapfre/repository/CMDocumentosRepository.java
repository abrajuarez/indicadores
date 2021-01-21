package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.indicador.mapfre.entity.CMDocumentos;


public interface CMDocumentosRepository extends PagingAndSortingRepository<CMDocumentos, Long>{
	
	@Query("SELECT doc.tipoDocumento FROM CMDocumentos doc WHERE doc.centralMedica.idSolicitud = :id")
	List<String> findFirstElementBYIdSolicitud(Pageable limit,@Param("id") Long IdSolicitud);

}
