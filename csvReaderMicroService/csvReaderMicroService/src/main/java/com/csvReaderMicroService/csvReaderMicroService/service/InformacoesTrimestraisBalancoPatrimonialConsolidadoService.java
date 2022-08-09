package com.csvReaderMicroService.csvReaderMicroService.service;
import com.csvReaderMicroService.csvReaderMicroService.Model.InformacoesTrimestraisBalancoPatrimonialConsolidado;
import com.csvReaderMicroService.csvReaderMicroService.Repository.ArquivoStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InformacoesTrimestraisBalancoPatrimonialConsolidadoService implements ArquivoStrategy {
    @Override
    public InformacoesTrimestraisBalancoPatrimonialConsolidado separarString(String string) {
        String[] separa = string.split(";");
        var objeto = new InformacoesTrimestraisBalancoPatrimonialConsolidado();
        objeto.setCnpjCia(separa[0]);
        objeto.setDataRefer(separa[1]);
        objeto.setVersao(Long.parseLong(separa[2]));
        objeto.setNomeCia(separa[3]);
        objeto.setCadastroCVM(Long.parseLong(separa[4]));
        objeto.setGrupoDfp(separa[5]);
        objeto.setMoeda(separa[6]);
        objeto.setEscalaMoeda(separa[7]);
        objeto.setOrdemExerc(separa[8]);
        objeto.setDataFimExercicio(separa[9]);
        objeto.setCodigoConta(separa[10]);
        objeto.setDescricaoConta(separa[11]);
        objeto.setValorConta(new BigDecimal(separa[12]));
        objeto.setContaFixa(separa[13]);

        return objeto;
    }
}
