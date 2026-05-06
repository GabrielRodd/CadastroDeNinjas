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

    //Injetando a camada de mapper na camada de service
    private MissaoMapper missaoMapper;

    //Criando o construtor da classe
    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
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

    //POST -- Criar Missao
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);
    }

    //DELETE -- Deletar Missao
    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }

    //PUT - Atualizar Missao
    public MissaoModel atualizaMissao(Long id, MissaoModel missaoAtualizada) {
        if (missaoRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        } else {
            return null;
        }
    }
}
