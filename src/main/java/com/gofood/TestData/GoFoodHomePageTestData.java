package com.gofood.TestData;

public enum GoFoodHomePageTestData {
    PAKET_AYAM_GEPREK("Paket Ayam Geprek (Rice)"),
    AYAM_GEPREK_BENERAN("Ayam Geprek Beneran (Rice)"),
    FRES_TEA("Fres Tea"),
    IKAN_BAKAR_BAWAL("Ikan Bakar Bawal (Rice)");
    private final String dish;

    private GoFoodHomePageTestData(String dish) {
        this.dish = dish;
    }

    public String getDish() {
        return dish;
    }


}
