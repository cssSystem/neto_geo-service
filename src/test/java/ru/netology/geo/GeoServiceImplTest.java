package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {
    @Test
    public void testByIp() {
        //arrange
        Country expected = Country.RUSSIA;
        GeoService geoService = new GeoServiceImpl();
        String strIP = "172.123.12.19";
        //act
        Location act = geoService.byIp(strIP);
        //assert
        Assertions.assertEquals(expected, act.getCountry());
    }
}
