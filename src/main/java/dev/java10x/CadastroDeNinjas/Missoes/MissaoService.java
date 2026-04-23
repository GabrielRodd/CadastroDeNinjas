package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    //Injetando a camada de repository na camada de service
    private MissaoRepository missaoRepository;

    //Criando o construtor da classe
    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //GET -- Mostrar missoes
    public List<MissaoModel> mostrarMissoes() {
        return missaoRepository.findAll();
    }
}
