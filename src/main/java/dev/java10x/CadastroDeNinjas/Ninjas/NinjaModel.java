package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;

// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro") //Nome da tabela
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Para funcionar de identificador na tabela

    private String nome;

    private int idade;

    private String email;

    private String cla;

    //@ManyToOne define que um ninja pode ter apenas UMA missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou Chave Estrangeira
    private MissaoModel missao;

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
