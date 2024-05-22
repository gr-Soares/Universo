package org.fema.beans;

public enum EstrelaTipo {
    ANA("Anã"),
    GIGANTE_VERMELHA("Gigante Vermelha"),
    SUPERGIGANTE_VERMELHA("Supergigante Vermelha"),
    NEBULOSA_PLANETARIA("Nebulosa Planetaria"),
    ANA_BRANCA("Anã Branca");

    private final String value;

    EstrelaTipo(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
