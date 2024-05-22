package org.fema.beans;public enum TipoGalaxia {
    ESPIRAL("Espiral"),
    ELIPTICA("Eliptica"),
    IRREGULAR("Irregular");

    private final String value;

    TipoGalaxia(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
