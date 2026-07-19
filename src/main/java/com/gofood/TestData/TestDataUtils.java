package com.gofood.TestData;

import java.util.HashMap;
import java.util.Map;

public class TestDataUtils {
    private static Map<String, String> LOGIN_DATA() {
        Map<String, String> user1 = new HashMap<String, String>();
        user1.put("phoneNumber", "3626483168");
        user1.put("phoneNumber1", "3765348759");
        user1.put("otp", "1234");
        user1.put("username", "S2");
        return user1;
    }

    private static Map<String, String> SEARCH_AREA() {
        Map<String, String> area = new HashMap<String, String>();
        area.put("jakarta", "jakarta");
        area.put("bali", "bali");
        area.put("yogyakarta", "yogyakarta");
        return area;
    }

    public static String getPhoneNumber() {
        return LOGIN_DATA().get("phoneNumber");
    }

    public static String getPhoneNumber1() {
        return LOGIN_DATA().get("phoneNumber1");
    }

    public static String getOTP() {
        return LOGIN_DATA().get("otp");
    }

    public static String getJakartaArea() {
        return SEARCH_AREA().get("jakarta");
    }

    public static String getBaliArea() {
        return SEARCH_AREA().get("bali");
    }

    public static String getYogyakartaArea() {
        return SEARCH_AREA().get("yogyakarta");
    }

    public static String getUserName() {
        return LOGIN_DATA().get("username");
    }

    private static Map<String, String> Cuisine() {
        Map<String, String> cuisine = new HashMap<String, String>();
        cuisine.put("Bakso & soto", "Bakso & soto");
        cuisine.put("Martabak", "Martabak");
        cuisine.put("Bakery", "Bakery");
        cuisine.put("Chinese", "Chinese");
        cuisine.put("Western", "Western");
        cuisine.put("Fast food", "Fast food");
        cuisine.put("Japanese", "Japanese");
        cuisine.put("Snacks", "Snacks");
        return cuisine;
    }

    public static String getBaksoSoto() {
        return Cuisine().get("Bakso & soto");
    }

    public static String getMartabak() {
        return Cuisine().get("Martabak");
    }

    public static String getBakery() {
        return Cuisine().get("Bakery");
    }

    public static String getWestern() {
        return Cuisine().get("Western");
    }

    public static String getFastFood() {
        return Cuisine().get("Fast food");
    }

    public static String getJapanese() {
        return Cuisine().get("Japanese");
    }

    public static String getSnacks() {
        return Cuisine().get("Snacks");
    }
}
