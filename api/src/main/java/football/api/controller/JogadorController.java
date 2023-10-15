package football.api.controller;

import football.api.jogador.DadosAtualizaJogador;
import football.api.jogador.DadosCadastroJogador;
import football.api.jogador.Jogador;
import football.api.jogador.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroJogador dados) {
        repository.save(new Jogador(dados));
    }


    @GetMapping
    public Page<Jogador> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getJogadorPorId(@PathVariable Long id) {
        Optional<Jogador> jogador = repository.findById(id);
        return jogador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaJogador dados) {
        var jogador = repository.getReferenceById(dados.id());
        jogador.atualizarInformacoes(dados);
    }

    //Exclusão fisica (apaga do banco)
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        //repository.deleteById(id);
        var jogador = repository.getReferenceById(id);
        jogador.excluir();
    }

}
@Configuration
class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedMethods("*").allowCredentials(false);
    }
}