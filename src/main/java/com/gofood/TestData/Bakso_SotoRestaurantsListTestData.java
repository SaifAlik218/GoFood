package com.gofood.TestData;

public enum Bakso_SotoRestaurantsListTestData {
    BAKMIE_BAKSO_17("Bakmie & Bakso 17"),
    SOTO_SEGER_PAK_JOGLO("Soto Seger Pak Joglo"),
    WARYBG_ABC("warybg, abc"),
    BAKSO_SAPI_HJ_AHMAD("Bakso Sapi Hj.Ahmad");
    private final String restaurant;

    Bakso_SotoRestaurantsListTestData(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
