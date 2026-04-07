package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity //Transforma em Entidade
@Table(name = "tb_missoes") //Nome Tabela
public class MissaoModel {

    @Id //Identifica o proximo atributo como id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id automatico na sequencia
    private Long id;

    private String nome;

    private String dificuldade;

    //@OneToMany define que uma missao pode ter VARIOS ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjasParticipantes;

}
