package br.edu.ifsp.domain.entities.booking;

public enum BookingStatus {
    OPEN("Aberto"),
    FINISHED("Finalizado"),
    CANCELED("Cancelado");

    private String label;

    BookingStatus(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
