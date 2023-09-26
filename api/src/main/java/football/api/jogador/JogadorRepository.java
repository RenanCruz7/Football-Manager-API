package football.api.jogador;

import org.springframework.data.jpa.repository.JpaRepository;

//fazer um repository na mão
public interface JogadorRepository extends JpaRepository<Jogador,Long> {
}
