package com.igarashiisrael.attornatusapi.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name = "pessoas")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long pessoaId;

    private String nome;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecos;

    public PessoaModel() {
    }

    public void atualizarContatos(){
        for(EnderecoModel end : this.enderecos){
            end.setPessoa(this);
        }
    }


    public PessoaModel(Long pessoaId, String nome, LocalDate dataNascimento) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoModel> getEndereco() {
        return enderecos;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.enderecos = endereco;
    }
}
