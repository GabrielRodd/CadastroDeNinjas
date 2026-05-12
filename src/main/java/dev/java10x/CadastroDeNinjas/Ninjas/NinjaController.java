package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinjaDTO.getNome() + " criado com sucesso! " + "ID: " + novoNinjaDTO.getId());
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/mostrar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
        List<NinjaDTO> listaNinjas = ninjaService.mostrarTodosNinjas(); //Aplica o metodo do NinjaService injetado
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaNinjas);
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/mostrar/{id}")//PathVariable o id entre chaves {id} entrada do user
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
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
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
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
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
