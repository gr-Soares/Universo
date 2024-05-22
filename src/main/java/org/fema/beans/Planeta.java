package org.fema.beans;

public class Planeta {
    private int cod;
    private String nome;
    private boolean habitavel;
    private Estrela estrela;

    public Planeta(int cod, String nome, boolean habitavel, Estrela estrela) {
        this.cod = cod;
        this.nome = nome;
        this.habitavel = habitavel;
        this.estrela = estrela;
    }

    public Planeta() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHabitavel() {
        return habitavel;
    }

    public void setHabitavel(boolean habitavel) {
        this.habitavel = habitavel;
    }

    public Estrela getEstrela() {
        return estrela;
    }

    public void setEstrela(Estrela estrela) {
        this.estrela = estrela;
    }
}
