package com.gofood.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.SearchLocationPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;

public class CommonFlowUtils {
    private static Logger log = LoggerFactory.getLogger(CommonFlowUtils.class);

    public static void searchAndSelectLocation(String area) {
        SearchLocationPage location = new SearchLocationPage();
        try {
            log.info("Attempting to enter location: {}", area);
            location.enterLocation(area).selectFirstOption(area);
            log.info("Sucessfully entered location: {}", area);
        } catch (Exception e) {
            String failedLocator = extractLocator(e);
            log.error("Failed to enter location: {}", area);
            throw new RuntimeException("searchAndSelectLocation failed for area: " + area + " | Reason: "
                    + e.getClass().getSimpleName() + "| Locator: " + failedLocator, e);
        }
    }

    public static  SearchRestroPage selectRestroAndDish() {
        SearchRestroPage restroPage  = new SearchRestroPage();
        try {
            log.info("Attempting to select restro and dish:");
            restroPage.clickBakmieBaksoRestro();
            new SelectDishPage().addBakmieAyanDish();
            log.info("Successfully selected restro and dish:");
            return restroPage;
        } catch (Exception e) {
            String failedLocator = extractLocator(e);
            log.error("Failed to select restro and dish");
            throw new RuntimeException("Selecting restro and failed : " + " | Reason: " + e.getClass().getSimpleName()
                    + " | Locator: " + failedLocator, e);
        }
    }

    public static LoginPage loginToAccount(String phoneNumber, String otp) {
        log.info("Attempting to enter phonenumber: {}", phoneNumber);
        LoginPage page = new LoginPage();
        try {

            page.modalLoginButton().enterPhoneNumber(phoneNumber).clickPhoneContinueButton().enterOTP(otp)
                    .clickOTPContinueButton();
            log.info("Successfully entered phonenumber: {}", phoneNumber);
            return page;
        } catch (Exception e) {
            String failedLocator = extractLocator(e);
            log.error("Failed to enter phonenumber {} | Locator: {}", phoneNumber, failedLocator, e);
            throw new RuntimeException("loginToAccount flow failed for phoneNumber: " + phoneNumber + " | Reason: "
                    + e.getClass().getSimpleName() + " | Locator: " + failedLocator, e);
        }
    }

    public static LoginPage loginToAccount(String phoneNumber, String otp, boolean clickHeaderLoginButton) {
        log.info("Attempting to enter phonenumber: {}", phoneNumber);
        LoginPage page = new LoginPage();
        if (clickHeaderLoginButton) {
            page.headerLoginButton();
        }
        try {

            page.modalLoginButton().enterPhoneNumber(phoneNumber).clickPhoneContinueButton().enterOTP(otp)
                    .clickOTPContinueButton();
            log.info("Successfully entered phonenumber: {}", phoneNumber);
            return page;
        } catch (Exception e) {
            String failedLocator = extractLocator(e);
            log.error("Failed to enter phonenumber {} | Locator: {}", phoneNumber, failedLocator, e);
            throw new RuntimeException("loginToAccount flow failed for phoneNumber: " + phoneNumber + " | Reason: "
                    + e.getClass().getSimpleName() + " | Locator: " + failedLocator, e);
        }
    }

    private static String extractLocator(Throwable e) {
        Throwable cause = e;
        while (cause != null) {
            String msg = cause.getMessage();
            if (msg != null && msg.contains("selector")) {
                // Selenium embeds:
                // {"method":"xpath","selector":"//input[@name='phone_number']"}
                int start = msg.indexOf("\"selector\":\"");
                if (start != -1) {
                    start += 12;
                    int end = msg.indexOf("\"", start);
                    return msg.substring(start, end);
                }
            }
            cause = cause.getCause();
        }
        return "unknown";
    }

}