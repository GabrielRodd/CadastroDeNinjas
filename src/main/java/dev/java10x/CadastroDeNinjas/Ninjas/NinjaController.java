package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //Criar uma dependencia/atributo do NinjaService na classe NinjaController
    //Dessa forma o NinjaController ganha acesso ao NinjaService
    //Esta injetando como dependencia o NinjaService
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/mostrar")
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.mostrarTodosNinjas(); //Aplica o metodo do NinjaService injetado
    }

    //Procurar Ninja por ID (READ)
    @GetMapping("/mostrar/{id}")//PathVariable o id entre chaves {id} entrada do user
    public NinjaModel mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.mostrarNinjasPorId(id);
    }

    //Alterar dados do Ninja (UPDATE)
    @PutMapping("/editar")
    public String editarNinjaPorId() {
        return "Editando Ninja por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId() {
        return "Ninja deletado por ID";
    }


}
