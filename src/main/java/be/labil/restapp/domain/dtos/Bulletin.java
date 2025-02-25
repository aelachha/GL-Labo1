package be.labil.restapp.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bulletin {
    private String uniteEtudeName;
    private Map<String, Double> matiereCotes;
}
