package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class MessageSenderImplTest {
    String someIpAddress = "IP............";

    @Mock
    private GeoServiceImpl geoService;

    @Mock
    private LocalizationServiceImpl localizationService;

    @Test
    public void LocationByCoordinatesTest() throws RuntimeException{

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            GeoService geoServiceImpl = null;
            geoServiceImpl.byCoordinates(28.4, 105.1);
        });
        System.out.println("Coordinate's successfully");

    }

    @Test
    void sendTestUSA() {
        String sendMessage = "Welcome";
        String message;

        Mockito.when(geoService.byIp(someIpAddress)).thenReturn(new Location("New York", Country.USA,
                " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, someIpAddress);
        message = messageSender.send(headers);
        Assertions.assertEquals(sendMessage, message);
        System.out.println("");
    }

    @Test
    void sendTestRussia() {
        String sendMessage = "Добро пожаловать";
        String message;

        Mockito.when(geoService.byIp(someIpAddress)).thenReturn(new Location("Moscow", Country.RUSSIA,
                "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, someIpAddress);
        message = messageSender.send(headers);
        Assertions.assertEquals(sendMessage, message );
        System.out.println("");
    }
}