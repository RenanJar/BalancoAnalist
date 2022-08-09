package com.csvReaderMicroService.csvReaderMicroService.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "tb_ItrBalancoTrimestralConsolidado")
public class InformacoesTrimestraisBalancoPatrimonialConsolidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CNPJ")
    private String cnpjCia;

    @Column(name = "DataReferencia")
    private String dataRefer;

    @Column(name = "versao")
    private Long versao;

    @Column(name = "nomeCia")
    private String nomeCia;

    @Column(name = "cadastroCvm")
    private Long cadastroCVM;

    @Column(name = "grupoDfp")
    private String grupoDfp;

    @Column(name = "moeda")
    private String moeda;

    @Column(name = "escalaMoeda")
    private String escalaMoeda;

    @Column(name = "ordemExerc")
    private String ordemExerc;

    @Column(name = "dataFimExercicio")
    private String dataFimExercicio;

    @Column(name = "codigoConta")
    private String codigoConta;

    @Column(name="descricaoConta")
    private String descricaoConta;

    @Column(name = "valorConta")
    private BigDecimal valorConta;

    @Column(name = "contaFixa")
    private String contaFixa;


    public InformacoesTrimestraisBalancoPatrimonialConsolidado() {
    }

    public InformacoesTrimestraisBalancoPatrimonialConsolidado(Long id, String cnpjCia,
                                                               String dataRefer, Long versao,String nomeCia,
                                                               Long cadastroCVM, String grupoDfp, String moeda,
                                                               String escalaMoeda, String ordemExerc, String dataFimExercicio,
                                                               String codigoConta,String descricaoConta, BigDecimal valorConta, String contaFixa) {
        this.id = id;
        this.cnpjCia = cnpjCia;
        this.dataRefer = dataRefer;
        this.versao = versao;
        this.nomeCia = nomeCia;
        this.cadastroCVM = cadastroCVM;
        this.grupoDfp = grupoDfp;
        this.moeda = moeda;
        this.escalaMoeda = escalaMoeda;
        this.ordemExerc = ordemExerc;
        this.dataFimExercicio = dataFimExercicio;
        this.codigoConta = codigoConta;
        this.descricaoConta = descricaoConta;
        this.valorConta = valorConta;
        this.contaFixa = contaFixa;
    }
}
