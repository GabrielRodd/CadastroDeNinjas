package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;

// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro") //Nome da tabela
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; //Para funcionar de identificador na tabela
    String nome;
    int idade;
    String email;
    String cla;

    //NoArgs Constructor
    public NinjaModel() {
    }

    //AllArgs Constructor
    public NinjaModel(String nome, int idade, String email, String cla) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cla = cla;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

}
