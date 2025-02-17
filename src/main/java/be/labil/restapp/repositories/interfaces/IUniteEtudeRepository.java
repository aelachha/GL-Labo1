package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.UniteEtude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUniteEtudeRepository extends JpaRepository<UniteEtude, Long> {
}
