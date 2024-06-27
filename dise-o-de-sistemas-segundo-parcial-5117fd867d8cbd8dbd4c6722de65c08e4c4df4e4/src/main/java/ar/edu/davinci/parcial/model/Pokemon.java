package ar.edu.davinci.parcial.model;

import jakarta.persistence.*;
import ar.edu.davinci.parcial.model.Entrenador;
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String especie;
    private float vida;
    private int poder;


    public Pokemon() {
    }

    public Pokemon(String tipo, String especie, float vida, int poder) {
        this.tipo = tipo;
        this.especie = especie;
        this.vida = vida;
        this.poder = poder;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public int getPoder() {

        return poder;
    }

    public void setPoder(int poder) {

        this.poder = poder;
    }

    public void atacar(Pokemon otroPokemon) {

    }
    public void restarVida(float cantidad) {

        this.vida -= cantidad;
    }

    public void aumentarVida(float cantidad) {
        this.vida += cantidad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        return id != null ? id.equals(pokemon.id) : pokemon.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", especie='" + especie + '\'' +
                ", vida=" + vida +
                ", poder=" + poder +
                '}';
    }
}
