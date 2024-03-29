package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrcamentoDto {

    private int id;
    private String nomeCliente;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private List<ProdutoOrcamentoDto> produtos;

    public Orcamento convertToEntity(){
        Orcamento orcamento = new Orcamento();
        List<ProdutoOrcamento> produtos = new ArrayList<>();

        if (!this.produtos.isEmpty()) {
            produtos = this.getProdutos().stream().map(
                            ProdutoOrcamentoDto::convertToEntity)
                    .collect(Collectors.toList());
        }

        orcamento.setNomeCliente(this.getNomeCliente());
        orcamento.setData(this.getData());
        orcamento.setProdutos(produtos);

        return orcamento;
    }

    public OrcamentoDto() {
    }

    public OrcamentoDto(int id, String nomeCliente, Date data, List<ProdutoOrcamentoDto> produtos) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.produtos = produtos;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoOrcamentoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoOrcamentoDto> produtos) {
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
