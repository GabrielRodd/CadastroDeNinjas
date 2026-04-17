package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
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
    @GetMapping("/mostrar")
    public String mostrarTodosNinjas() {
        return "Mostrando Todos Ninjas";
    }

    //Procurar Ninja por ID (READ)
    @GetMapping("/mostrarID")
    public String mostrarNinjasPorId() {
        return "Mostrando por ID";
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
