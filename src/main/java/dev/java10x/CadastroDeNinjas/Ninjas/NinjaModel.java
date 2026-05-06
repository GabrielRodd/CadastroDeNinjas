package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Entity transforma uma classe em uma entidade do DB
@Table(name = "tb_cadastro") //Nome da tabela
@NoArgsConstructor //Anotation importada do lombok, cria um noargsconstructor invisivel
@AllArgsConstructor //Anotation importada do lombok, cria um AllArgsConstructor invisivel, que atualiza sozinho
@Data //Anotation importada do lombok, cria TODOS os GETTERS e os SETTERS invisiveis
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //Para funcionar de identificador na tabela

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(unique = true) //Proibe dados repetidos na coluna email
    private String email;

    @Column(name = "cla")
    private String cla;

    @Column(name = "rank")
    private String rank;

    //@ManyToOne define que um ninja pode ter apenas UMA missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou Chave Estrangeira
    private MissaoModel missao;

}
