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

    //GET -- Mostrar Missoes por ID
    @GetMapping("mostrar/{id}")
    public MissaoModel mostrarPorID(@PathVariable Long id) {
        return missaoService.mostrarPorID(id);
    }

    //POST -- Criar Missao
    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missaoService.criarMissao(missao);
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
