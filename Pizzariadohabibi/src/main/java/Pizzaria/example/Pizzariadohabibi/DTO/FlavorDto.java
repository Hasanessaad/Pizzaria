package Pizzaria.example.Pizzariadohabibi.DTO;

import jakarta.persistence.*;

public class FlavorDto {
    private String nome;

    private Float preco_adicional;


    public FlavorDto() {
    }

    public FlavorDto( String nome, Float preco_adicional) {
        this.nome = nome;
        this.preco_adicional = preco_adicional;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco_adicional() {
        return preco_adicional;
    }

    public void setPreco_adicional(Float preco_adicional) {
        this.preco_adicional = preco_adicional;
    }
}
