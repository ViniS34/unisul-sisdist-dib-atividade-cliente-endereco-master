package br.unisul.aula.mscliente.dto;


import java.util.List;

public class ResultadoDTO {

    private String cidade;
    private String uf;
    private List<ClienteCidadeDTO> clientes;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<ClienteCidadeDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteCidadeDTO> clientes) {
        this.clientes = clientes;
    }
}
