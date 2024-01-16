package com.senac.senac.enums;

public enum ProductTypeEnum {
    RING(1L, "Anel"),
    EARRING(2L, "Brinco"),
    BRACELET(3L, "Pulseira");

    private final Long id;
    private final String name;

    ProductTypeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ProductTypeEnum getById(int id) {
        for (ProductTypeEnum productType : values()) {
            if (productType.id == id) {
                return productType;
            }
        }
        throw new IllegalArgumentException("No ProductType found with ID: " + id);
    }
}
