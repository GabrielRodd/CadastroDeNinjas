package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //Anotation que define a classe NinjaService como camada de servico
public class NinjaService {

    //Criar uma dependencia/atributo do NinjaRepository na classe NinjaService
    //Dessa forma o NinjaService ganha acesso ao NinjaRepository
    //Esta injetando como dependencia o NinjaRepository
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    //Iniciar o construtor da classe
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Mostrar todos os Ninjas
    public List<NinjaDTO> mostrarTodosNinjas() {
        List<NinjaModel> listaNinjasModel = ninjaRepository.findAll();
        return listaNinjasModel.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Mostrar ninja por ID
    public NinjaDTO mostrarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaID= ninjaRepository.findById(id);
        return ninjaID.map(ninjaMapper::map).orElse(null);
    }

    //Adicionar Ninja (CREATE)
    public NinjaDTO criarNinja(NinjaDTO novoNinja) {
        NinjaModel ninjaModel = ninjaMapper.map(novoNinja);
        ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Deletar Ninja (DELETE) - Tem que ser um metodo void, pois nao vai ser enviado/retornado nada
    public NinjaDTO deletarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaDeletadoModel = ninjaRepository.findById(id);
        ninjaRepository.deleteById(id);
        return ninjaDeletadoModel.map(ninjaMapper::map).orElse(null);
    }

    //Atualizar Ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizadoDTO) {
        if (ninjaRepository.existsById(id)) {
            NinjaModel ninjaAtualizadoModel = ninjaMapper.map(ninjaAtualizadoDTO);
            ninjaAtualizadoModel.setId((id));
            ninjaRepository.save(ninjaAtualizadoModel);
            return ninjaMapper.map(ninjaAtualizadoModel);
        } else {
            return null;
        }
    }
}
