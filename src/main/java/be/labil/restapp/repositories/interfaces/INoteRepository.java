package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {
}
