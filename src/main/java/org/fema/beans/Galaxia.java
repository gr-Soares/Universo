package org.fema.beans;

public class Galaxia {
    private int cod;
    private String nome;
    private TipoGalaxia tipo;

    public Galaxia() {

    }

    public Galaxia(int cod, String nome, TipoGalaxia tipo) {
        this.cod = cod;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public TipoGalaxia getTipo() {
        return tipo;
    }

    public void setTipo(TipoGalaxia tipo) {
        this.tipo = tipo;
    }
}
