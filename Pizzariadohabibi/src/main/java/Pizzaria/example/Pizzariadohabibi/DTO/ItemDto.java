package Pizzaria.example.Pizzariadohabibi.DTO;


import java.util.List;

public class ItemDto {


    private String codigo;
    private Float preco;
    private Boolean pizza;
    private Integer tamanho;
    private String extra;
    private String remove;
    private List<Long> flavor;

    public ItemDto() {
    }

    public ItemDto(String codigo, Float preco, Boolean pizza, Integer tamanho, String extra, String remove, List<Long> flavor) {
        this.codigo = codigo;
        this.preco = preco;
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.extra = extra;
        this.remove = remove;
        this.flavor = flavor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean getPizza() {
        return pizza;
    }

    public void setPizza(Boolean pizza) {
        this.pizza = pizza;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public List<Long> getFlavor() {
        return flavor;
    }

    public void setFlavor(List<Long> flavor) {
        this.flavor = flavor;
    }
}