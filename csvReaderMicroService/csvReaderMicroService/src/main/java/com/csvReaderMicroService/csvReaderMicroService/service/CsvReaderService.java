package com.csvReaderMicroService.csvReaderMicroService.service;

import com.csvReaderMicroService.csvReaderMicroService.Model.InformacoesTrimestraisBalancoPatrimonialConsolidado;
import com.csvReaderMicroService.csvReaderMicroService.Repository.InformacoesTrimestraisBalancoPatrimonialConsolidadoRepository;
import com.csvReaderMicroService.csvReaderMicroService.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    @Autowired
    InformacoesTrimestraisBalancoPatrimonialConsolidadoService
    informacoesTrimestraisBalancoPatrimonialConsolidadoService;

    @Autowired
    InformacoesTrimestraisBalancoPatrimonialConsolidadoRepository
    informacoesTrimestraisBalancoPatrimonialConsolidadoRepository;

    @Value("#{'${listCnpj}'.split(',')}")
    List<String> listCnpj;

    @RabbitListener(queues = "csvRead")
    public void consumidor(String path) throws IOException {
        Path pathreceived = Path.of(path);
        this.leitorCsv(pathreceived,listCnpj);
    }

    public boolean verificaExistencia(List<InformacoesTrimestraisBalancoPatrimonialConsolidado> lista,
                                      String cnpj, String codigoConta, Long versao){

        boolean existe = lista.stream()
                .anyMatch(objeto-> objeto.getCnpjCia().matches(cnpj) &&
                        objeto.getCodigoConta().matches(codigoConta) &&
                        objeto.getVersao() == versao);

        return existe;
    }
    public void leitorCsv(Path path, List<String> cnpj) throws IOException {

        List<InformacoesTrimestraisBalancoPatrimonialConsolidado> allRegistry =
                informacoesTrimestraisBalancoPatrimonialConsolidadoRepository.findAll();

        Files.lines(path, StandardCharsets.ISO_8859_1)
                .skip(1)
                .map(line -> informacoesTrimestraisBalancoPatrimonialConsolidadoService
                        .separarString(line))
                .filter(objeto -> cnpj.contains(objeto.getCnpjCia()))
                .filter(objeto -> !this.verificaExistencia(allRegistry,
                        objeto.getCnpjCia(),
                        objeto.getCodigoConta(),
                        objeto.getVersao()))
                .forEach(objetofiltrado -> informacoesTrimestraisBalancoPatrimonialConsolidadoRepository
                        .save(objetofiltrado));
        Files.delete(path);
    }
}
