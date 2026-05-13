package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    //Injetando a camada de repository na camada de service
    private final MissaoRepository missaoRepository;

    //Injetando a camada de mapper na camada de service
    private final MissaoMapper missaoMapper;

    //Criando o construtor da classe
    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //GET -- Mostrar missoes
    public List<MissaoDTO> mostrarMissoes() {
        List<MissaoModel> listaMissaoModel = missaoRepository.findAll();
        return listaMissaoModel.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    //GET -- Mostrar Missoes por ID
    public MissaoDTO mostrarPorID(Long id) {
        Optional<MissaoModel> missaoIdModel = missaoRepository.findById(id);
        return missaoIdModel.map(missaoMapper::map).orElse(null);
    }

    //POST -- Criar Missao
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);
    }

    //DELETE -- Deletar Missao
    public MissaoDTO deletarMissao(Long id) {
        Optional<MissaoModel> missaoDeletar = missaoRepository.findById(id);
        missaoRepository.deleteById(id);
        return missaoDeletar.map(missaoMapper::map).orElse(null);
    }

    //PUT - Atualizar Missao
    public MissaoDTO atualizaMissao(Long id, MissaoDTO missaoAtualizadaDTO) {
        if (missaoRepository.existsById(id)) {
            MissaoModel missaoAtualizadaModel = missaoMapper.map(missaoAtualizadaDTO);
            missaoAtualizadaModel.setId(id);
            missaoRepository.save(missaoAtualizadaModel);
            return missaoMapper.map(missaoAtualizadaModel);
        } else {
            return null;
        }
    }
}

