package ar.edu.davinci.parcial.service;

import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon crearPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
      public Pokemon recuperarPokemonPorId(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public List<Pokemon> buscarPokemonsPorRangoDePoder(int minPoder, int maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }

    public List<Pokemon> buscarPokemonsPorTipo(String tipo) {
        return pokemonRepository.findByTipoIgnoreCase(tipo);
    }

}
