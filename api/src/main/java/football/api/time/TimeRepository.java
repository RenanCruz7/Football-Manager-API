package football.api.time;

import football.api.jogador.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Page<Time> findAllByAtivoTrue(Pageable paginacao);
}
