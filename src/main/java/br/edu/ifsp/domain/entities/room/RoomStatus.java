package br.edu.ifsp.domain.entities.room;

public enum RoomStatus {
    AVAILABLE("DISPONIVEL"),
    OCCUPIED("OCUPADO"),
    INACTIVE("INATIVO");

    private final String label;

    RoomStatus(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
