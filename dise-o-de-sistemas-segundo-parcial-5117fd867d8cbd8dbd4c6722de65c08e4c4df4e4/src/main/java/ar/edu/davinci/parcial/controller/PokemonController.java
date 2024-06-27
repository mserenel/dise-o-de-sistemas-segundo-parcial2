package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/crear")
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.crearPokemon(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon recuperarPokemonPorId(@PathVariable Long id) {
        return pokemonService.recuperarPokemonPorId(id);
    }

    @GetMapping("/buscar-por-rango")
    public List<Pokemon> buscarPokemonsPorRangoDePoder(@RequestParam int minPoder, @RequestParam int maxPoder) {
        return pokemonService.buscarPokemonsPorRangoDePoder(minPoder, maxPoder);
    }

    @GetMapping("/buscar-por-tipo")
    public List<Pokemon> buscarPokemonsPorTipo(@RequestParam String tipo) {
        return pokemonService.buscarPokemonsPorTipo(tipo);
    }
}
