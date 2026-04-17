package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    //GET -- Mostrar missoes
    @GetMapping("mostrar")
    public String mostrarMissoes() {
        return "Mostrando missoes";
    }

    //POST -- Criar Missao
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao Criada.";
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
