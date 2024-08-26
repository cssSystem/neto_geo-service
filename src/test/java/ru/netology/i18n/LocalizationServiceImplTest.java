package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {
    @Test
    public void localeTest() {
        //arrange
        String expected = "Добро пожаловать";//"Welcome"
        Country country = Country.RUSSIA;//.USA;
        LocalizationService loc = new LocalizationServiceImpl();
        //act
        String act = loc.locale(country);
        //assert
        Assertions.assertEquals(expected, act);
    }
}
