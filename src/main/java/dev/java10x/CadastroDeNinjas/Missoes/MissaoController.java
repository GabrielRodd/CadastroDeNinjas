package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    //Injetando a camada de service na camada de controller
    private MissaoService missaoService;

    //Criando o construtor da classe
    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }


    //GET -- Mostrar missoes
    @GetMapping("mostrar")
    public List<MissaoModel> mostrarMissoes() {
        return missaoService.mostrarMissoes();
    }

    //POST -- Criar Missao
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao Criada.";
    }

    //PUT -- Editar Missao
    @PutMapping("/editar")
    public String editarMissao() {
        return "Missao Editada.";
    }

    //DELETE -- Deletar Missao
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao Deletada.";
    }
}
