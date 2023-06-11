package br.edu.ifsp.domain.entities.product;

public enum ProductStatus {
    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    private final String label;

    ProductStatus(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
