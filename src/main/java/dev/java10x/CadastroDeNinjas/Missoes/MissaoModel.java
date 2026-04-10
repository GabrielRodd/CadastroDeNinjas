package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //Transforma em Entidade
@Table(name = "tb_missoes") //Nome Tabela
@NoArgsConstructor //Anotation importada do lombok, cria um noargsconstructor invisivel
@AllArgsConstructor //Anotation importada do lombok, cria um AllArgsConstructor invisivel, que atualiza sozinho
@Data //Anotation importada do lombok, cria TODOS os GETTERS e os SETTERS invisiveis
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
