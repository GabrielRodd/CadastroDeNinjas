package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service //Anotation que define a classe NinjaService como camada de servico
public class NinjaService {

    //Criar uma dependencia/atributo do NinjaRepository na classe NinjaService
    //Dessa forma o NinjaService ganha acesso ao NinjaRepository
    //Esta injetando como dependencia o NinjaRepository
    private NinjaRepository ninjaRepository;

    //Iniciar o construtor da classe
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Mostrar todos os Ninjas
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaRepository.findAll();
    }













}
