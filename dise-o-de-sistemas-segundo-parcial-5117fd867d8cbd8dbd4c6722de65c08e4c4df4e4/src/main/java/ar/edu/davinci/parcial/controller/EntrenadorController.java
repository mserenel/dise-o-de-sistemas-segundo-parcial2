package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @PostMapping("/crear")
    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.crearEntrenador(entrenador);
    }

    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable Long id) {
        return entrenadorService.getById(id);
    }

    @GetMapping("/buscar")
    public List<Entrenador> buscarPorNombre(@RequestParam String nombre) {
        return entrenadorService.buscarPorNombre(nombre);
    }

    @PostMapping("/{id}/capturar")
    public void capturarPokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        entrenadorService.capturarPokemon(id, pokemon);
    }

    @PostMapping("/{id}/enfrentar/{otroId}")
    public void enfrentarseA(@PathVariable Long id, @PathVariable Long otroId) {
        entrenadorService.enfrentarseA(id, otroId);
    }
}
