package ar.edu.davinci.parcial.service;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.davinci.parcial.repository.EntrenadorRepository;

import java.util.List;

@Service
@Transactional
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador crearEntrenador(Entrenador entrenador) {

        return entrenadorRepository.save(entrenador);
    }

    public Entrenador getById(Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con ID: " + id));
    }

    public Entrenador getByNombre(String nombre) {

        return entrenadorRepository.findByNombreIgnoreCase(nombre);
    }

    public void capturarPokemon(Long entrenadorId, Pokemon pokemon) {
        Entrenador entrenador = getById(entrenadorId);
        entrenador.capturarPokemon(pokemon);
        entrenadorRepository.save(entrenador);
    }

    public void enfrentarseA(Long entrenadorId, Long otroEntrenadorId) {
        Entrenador entrenador = getById(entrenadorId);
        Entrenador otroEntrenador = getById(otroEntrenadorId);
        entrenador.enfrentarseA(otroEntrenador);
        entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> buscarPorNombre(String nombre) {
        return entrenadorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
