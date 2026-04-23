package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //GET -- Mostrar Missoes por ID
    public MissaoModel mostrarPorID(Long id) {
        Optional<MissaoModel> missaoIdMostrar = missaoRepository.findById(id);
        return missaoIdMostrar.orElse(null);
    }
}
