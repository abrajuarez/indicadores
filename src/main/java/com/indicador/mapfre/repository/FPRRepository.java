package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;

@Repository
public interface FPRRepository extends JpaRepository<XxmpfBpmIndEmision, String>{

	@Query("SELECT emision FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle ON emision.idEmision = detalle.idEmisionFK WHERE detalle.area = 'Emisión' AND  emision.estatus != 'En Procesos' AND detalle.estatus != 'En Proceso' AND emision.fechaInicio > :dateStart AND emision.fechaInicio < :dateFinish")
	List<XxmpfBpmIndEmision> allFolioRecibidoByFechaInicio(@Param("dateStart") String dateStart, @Param("dateFinish")  String dateFinish);

	@Query("SELECT emision FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle ON emision.idEmision = detalle.idEmisionFK WHERE detalle.area = 'Emisión' AND  emision.estatus != 'En Procesos' AND detalle.estatus != 'En Proceso' AND emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> allFolioAtendidoByFechaFin(@Param("dateStart") String dateStart, @Param("dateFinish")  String dateFinish);
}
