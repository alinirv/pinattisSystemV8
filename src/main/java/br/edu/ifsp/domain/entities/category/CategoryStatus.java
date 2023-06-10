package br.edu.ifsp.domain.entities.category;

public enum CategoryStatus {

        AVAILABLE("Disponivel"),
        BOOKED_OUT("Reservado"),
        IN_USE("Em uso"),
        MAINTENACE("Manutenção");

        private String label;

        CategoryStatus(String label){
        this.label = label;
    }

        @Override
        public String toString() {
        return label;
    }
}
