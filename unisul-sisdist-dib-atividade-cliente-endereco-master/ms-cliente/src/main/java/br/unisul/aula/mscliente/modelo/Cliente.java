package br.unisul.aula.mscliente.modelo;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq_cliente",sequenceName="my_seq_cliente", allocationSize=1)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Long id;
    private String nome;
    @Column(name = "endereco_id")
    private Long idEndereco;
    private String complemento;
    private Integer numero;

    public Cliente() {
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idEndereco=" + idEndereco +
                ", complemento='" + complemento + '\'' +
                ", numero=" + numero +
                '}';
    }
}
