package Pizzaria.example.Pizzariadohabibi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Flavor" , schema = "public")
public class Flavor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    //algumas pizzarias tem sabores que contam com um adicional de preco
    private Float preco_adicional;


    public Flavor() {
    }

    public Flavor(Long id, String nome, Float preco_adicional) {
        this.id = id;
        this.nome = nome;
        this.preco_adicional = preco_adicional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
