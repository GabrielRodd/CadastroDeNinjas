package dev.java10x.CadastroDeNinjas.Ninjas;

import ch.qos.logback.core.boolex.EvaluationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //Criar uma dependencia/atributo do NinjaService na classe NinjaController
    //Dessa forma o NinjaController ganha acesso ao NinjaService
    //Esta injetando como dependencia o NinjaService
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota retorna uma mensagem de boas vindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinjaDTO.getNome() + " criado com sucesso! " + "ID: " + novoNinjaDTO.getId());
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/mostrar")
    @Operation(summary = "Mostra os ninjas cadastrados", description = "Rota mostra todos os ninjas cadastrados no banco de dados")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
        List<NinjaDTO> listaNinjas = ninjaService.mostrarTodosNinjas(); //Aplica o metodo do NinjaService injetado
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaNinjas);
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/mostrar/{id}")//PathVariable o id entre chaves {id} entrada do user
    @Operation(summary = "Mostrar ninja por ID", description = "Rota mostra o Ninja com base em seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Encontrado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao localizado")
    })
    public ResponseEntity<Object> mostrarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaBuscado = ninjaService.mostrarNinjasPorId(id);
        if (ninjaBuscado != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaBuscado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id " + id + " nao encontrado");
        }
    }

    //Atualizar dados do Ninja (UPDATE)
    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Edita um ninja por ID", description = "Rota edita o Ninja com base em seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Alterado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao localizado, impossivel alterar")
    })
    public ResponseEntity<String> atualizarNinja(
            @Parameter(description = "Usuario manda o ID no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaAtualizar = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaAtualizar != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja de ID " + ninjaAtualizar.getId() + " atualizado com sucesso") ;
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " nao existe no Cadastro de Ninjas");
        }
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por ID", description = "Rota deleta o Ninja com base em seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Deletado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao localizado, impossivel deletar")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario manda o ID no caminho da requisicao")
            @PathVariable Long id) {
        NinjaDTO ninjaDeletado = ninjaService.deletarNinjaPorId(id);
        if (ninjaDeletado!=null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja " + ninjaDeletado.getNome() + " deletado com sucesso! " + "ID: " + ninjaDeletado.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao existente");
        }
    }

}
