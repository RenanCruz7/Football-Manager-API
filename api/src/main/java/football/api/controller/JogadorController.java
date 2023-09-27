package football.api.controller;

import football.api.jogador.DadosCadastroJogador;
import football.api.jogador.Jogador;
import football.api.jogador.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroJogador dados){
        repository.save(new Jogador(dados));
    }
}
