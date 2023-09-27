package football.api.controller;

import football.api.jogador.JogadorRepository;
import football.api.time.DadosCadastroTime;
import football.api.time.Time;
import football.api.time.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("times")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTime dados){
        repository.save(new Time(dados));
    }

}
