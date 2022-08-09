package com.csvReaderMicroService.csvReaderMicroService.Repository;

import com.csvReaderMicroService.csvReaderMicroService.Model.InformacoesTrimestraisBalancoPatrimonialConsolidado;

public interface ArquivoStrategy {

    public InformacoesTrimestraisBalancoPatrimonialConsolidado separarString(String string);


}
