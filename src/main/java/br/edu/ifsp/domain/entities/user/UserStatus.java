package br.edu.ifsp.domain.entities.user;

public enum UserStatus {
    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    private final String label;

    UserStatus(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
