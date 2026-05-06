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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/mostrar")
    public List<NinjaDTO> mostrarTodosNinjas() {
        return ninjaService.mostrarTodosNinjas(); //Aplica o metodo do NinjaService injetado
    }

    //Procurar Ninja por ID (READ)
    @GetMapping("/mostrar/{id}")//PathVariable o id entre chaves {id} entrada do user
    public NinjaDTO mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.mostrarNinjasPorId(id);
    }

    //Atualizar dados do Ninja (UPDATE)
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }


}
