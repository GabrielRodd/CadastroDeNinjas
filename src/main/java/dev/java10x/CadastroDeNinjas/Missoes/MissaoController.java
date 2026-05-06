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
    public List<MissaoDTO> mostrarMissoes() {
        return missaoService.mostrarMissoes();
    }

    //GET -- Mostrar Missoes por ID
    @GetMapping("mostrar/{id}")
    public MissaoDTO mostrarPorID(@PathVariable Long id) {
        return missaoService.mostrarPorID(id);
    }

    //POST -- Criar Missao
    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return missaoService.criarMissao(missao);
    }

    //DELETE -- Deletar Missao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissao(id);
    }

    //PUT -- Atualizar Missao
    @PutMapping("/atualizar/{id}")
    public MissaoDTO atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada) {
        return missaoService.atualizaMissao(id, missaoAtualizada);
    }
}
