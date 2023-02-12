package ru.netology.geo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

class GeoServiceImplTest {

    @Test
    void ipTest() {
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        String ip = "172.123.12.19";
        Location actualLocation = geoServiceImpl.byIp(ip);
        Country expectedCountry = Country.RUSSIA;
        Assertions.assertEquals(expectedCountry, actualLocation.getCountry());
        System.out.println("GeoServiceImplTest successfully...");
    }
}