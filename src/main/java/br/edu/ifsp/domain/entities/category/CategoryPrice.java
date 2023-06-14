package br.edu.ifsp.domain.entities.category;

public enum CategoryPrice {
    ONE_HOUR("1 Hora"),
    TWO_HOURS( "2 Horas"),
    ALL_NIGHT( "Pernoite"),
    ADDITIONAL_HOUR( "Hora Adicional");

    private String label;

    CategoryPrice(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
