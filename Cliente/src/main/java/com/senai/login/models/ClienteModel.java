package com.senai.login.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="CLIENTE")
public class ClienteModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="clienteNome")
    private String nome;
    @Column(name="clienteEmail")
    private String email;
    @Column(name="clienteTelefone")
    private String telefone;
    @Column(name="clienteDataCadastro")
    private LocalDate dataDeCadastro;
    @Column(name="clienteEndereco")
    private String endereco;
    @Column(name="clienteNumeroEndereco")
    private int numeroEndereco;

    public ClienteModel() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }
    
    
}