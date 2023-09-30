package football.api.controller;

import football.api.jogador.DadosAtualizaJogador;
import football.api.jogador.Jogador;
import football.api.jogador.JogadorRepository;
import football.api.time.DadosAtualizaTime;
import football.api.time.DadosCadastroTime;
import football.api.time.Time;
import football.api.time.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public Page<Time> listar(@PageableDefault(size = 10,sort = "nome") Pageable paginacao){
        return repository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimePorId(@PathVariable Long id) {
        Optional<Time> time = repository.findById(id);
        return time.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaTime dados){
        var time = repository.getReferenceById(dados.id());
        time.atualizarInformacoes(dados);
    }

    //Exclusão fisica (apaga do banco)
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //repository.deleteById(id);
        var time = repository.getReferenceById(id);
        time.excluir();
    }

}
