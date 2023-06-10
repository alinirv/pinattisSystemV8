package br.edu.ifsp.domain.entities.category;

public enum CategoryPrice {
    ONE_HOUR("50.00"),
    TWO_HOURS( "100.00"),
    EXTRA_HOUR( "60.00"),
    ALL_NIGHT( "150.00"),
    HORA_ADICIONAL( "60.00");

    private String label;

    CategoryPrice(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
