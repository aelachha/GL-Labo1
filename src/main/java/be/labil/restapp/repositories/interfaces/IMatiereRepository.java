package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatiereRepository extends JpaRepository<Matiere, Long> {
    Matiere findByNom(String nom);

}
