package ar.edu.davinci.parcial.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String genero;
    private int edad;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pokemon> pokemons = new ArrayList<>();

    public Entrenador() {
    }

    public Entrenador(String nombre, String fechaNacimiento, String nacionalidad, String genero, int edad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getFechaNacimiento() {

        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {

        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {

        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {

        return genero;
    }

    public void setGenero(String genero) {

        this.genero = genero;
    }

    public int getEdad() {

        return edad;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void capturarPokemon(Pokemon pokemon) {
        if (pokemons.size() < 5) {
            pokemons.add(pokemon);
        } else {
            throw new RuntimeException("No se pueden capturar más de 5 pokemons");
        }
    }

    public void enfrentarseA(Entrenador otroEntrenador) {
    }
}
