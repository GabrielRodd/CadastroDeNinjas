package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    //Injetando a camada de service na camada de controller
    private final MissaoService missaoService;

    //Criando o construtor da classe
    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }


    //GET -- Mostrar missoes
    @GetMapping("mostrar")
    public ResponseEntity<List<MissaoDTO>> mostrarMissoes() {
        List<MissaoDTO> listaMissoes = missaoService.mostrarMissoes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaMissoes);
    }

    //GET -- Mostrar Missoes por ID
    @GetMapping("mostrar/{id}")
    public ResponseEntity<Object> mostrarPorID(@PathVariable Long id) {
        MissaoDTO missaoBuscada = missaoService.mostrarPorID(id);
        if (missaoBuscada != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missaoBuscada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de id " + id + " nao existe no banco de dados");
        }
    }

    //POST -- Criar Missao
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO missaoCriada = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão " + missaoCriada.getId() + " criada com sucesso");
    }

    //DELETE -- Deletar Missao
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        MissaoDTO missaoDeletar = missaoService.deletarMissao(id);
        if (missaoDeletar != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missao de id " + missaoDeletar.getId() + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada no banco de dados");
        }
    }

    //PUT -- Atualizar Missao
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada) {
        MissaoDTO missaoNova = missaoService.atualizaMissao(id, missaoAtualizada);
        if (missaoNova != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missao de id " + missaoNova.getId() + " editada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de id " + id + " nao existe no bando de dados");
        }
    }
}
