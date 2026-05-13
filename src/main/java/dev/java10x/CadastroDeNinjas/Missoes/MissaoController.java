package dev.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mostra todas as missoes", description = "Rota mostra todas as missoes do banco de dados")
    public ResponseEntity<List<MissaoDTO>> mostrarMissoes() {
        List<MissaoDTO> listaMissoes = missaoService.mostrarMissoes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaMissoes);
    }

    //GET -- Mostrar Missoes por ID
    @GetMapping("mostrar/{id}")
    @Operation(summary = "Mostra uma missao", description = "Rota mostra uma missao a partir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Encontrada com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao localizada")
    })
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
    @Operation(summary = "Criar uma missao", description = "Rota cria uma nova missao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao Criada com Sucesso"),
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO missaoCriada = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão " + missaoCriada.getId() + " criada com sucesso");
    }

    //DELETE -- Deletar Missao
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar uma missao", description = "Rota deleta uma missao pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Deletada com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada"),
    })
    public ResponseEntity<String> deletarMissao(
            @Parameter(description = "Usuario manda o ID no caminho da requisicao")
            @PathVariable Long id) {
        MissaoDTO missaoDeletar = missaoService.deletarMissao(id);
        if (missaoDeletar != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missao '" + missaoDeletar.getNome() + "' deletada com sucesso. ID: " + missaoDeletar.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada no banco de dados");
        }
    }

    //PUT -- Atualizar Missao
    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar uma missao", description = "Rota atualiza uma missao pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Atualizada com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada"),
    })
    public ResponseEntity<String> atualizarMissao(
            @Parameter(description = "Usuario manda o ID no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda o novo conteudo no corpo da requisicao")
            @RequestBody MissaoDTO missaoAtualizada) {
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
