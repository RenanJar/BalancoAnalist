package com.csvReaderMicroService.csvReaderMicroService.Repository;

import com.csvReaderMicroService.csvReaderMicroService.Model.InformacoesTrimestraisBalancoPatrimonialConsolidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacoesTrimestraisBalancoPatrimonialConsolidadoRepository
        extends JpaRepository<InformacoesTrimestraisBalancoPatrimonialConsolidado,Long> {

        boolean existsByVersaoAndCnpjCia(Long versao, String CnpjCia);

}
