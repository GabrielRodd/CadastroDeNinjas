package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado.";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Mostrando Todos Ninjas";
    }

    //Procurar Ninja por ID (READ)
    @GetMapping("/todosID")
    public String mostrarNinjasPorId() {
        return "Mostrando por ID";
    }

    //Alterar dados do Ninja (UPDATE)
    @PutMapping("/editarNinjaID")
    public String editarNinjaPorId() {
        return "Editando Ninja por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarNinjaID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por ID";
    }


}
