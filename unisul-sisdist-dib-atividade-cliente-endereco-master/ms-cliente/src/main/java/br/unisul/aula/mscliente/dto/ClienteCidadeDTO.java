package br.unisul.aula.mscliente.dto;

import br.unisul.aula.mscliente.modelo.Cliente;

public class ClienteCidadeDTO {
    private Long id;
    private String nome;

    public ClienteCidadeDTO() {
    }

    public ClienteCidadeDTO(Cliente cliente, EnderecoDTO enderecoDTO) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.setEndereco(enderecoDTO);
    }

    public void setEndereco(EnderecoDTO enderecoDTO) {
         this.id = enderecoDTO.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
