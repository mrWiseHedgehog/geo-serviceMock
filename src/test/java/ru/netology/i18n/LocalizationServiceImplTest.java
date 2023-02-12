package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


public class LocalizationServiceImplTest {

    @Test
    void localeTest() {
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        String sendMessage = "Welcome";
        String message = localizationServiceImpl.locale(Country.USA);
        Assertions.assertEquals(sendMessage, message);
        System.out.println("LocalizationServiceImplTest successfully");
    }
}
