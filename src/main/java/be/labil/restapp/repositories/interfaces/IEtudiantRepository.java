package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.UniteEtude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByNom(String nom);

}
