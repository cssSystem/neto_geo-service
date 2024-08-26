package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MessageSenderImplTest {
    public static Stream<String> TestMessageSenderImplEng() {
        return Stream.of(
                "96.08.05.36",
                "96.45.787.42",
                "172.154.1.151"

        );
    }

    @MethodSource
    @ParameterizedTest
    public void TestMessageSenderImplEng(String ip) {
        //arrange
        String expected = "Welcome";

        GeoServiceImpl geo = Mockito.spy(GeoServiceImpl.class);

        LocalizationServiceImpl loc = Mockito.spy(LocalizationServiceImpl.class);


        MessageSender messageSender = new MessageSenderImpl(geo, loc);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);


        //act
        String act = messageSender.send(map);
        //assert
        Assertions.assertEquals(expected, act);
    }

    public static Stream<String> TestMessageSenderImplRus() {
        return Stream.of(
                "172.168.0.1",
                "96.45.787.42",
                "172.154.1.151"

        );
    }

    @MethodSource
    @ParameterizedTest
    public void TestMessageSenderImplRus(String ip) {
        //arrange
        String expected = "Добро пожаловать";

        GeoServiceImpl geo = Mockito.spy(GeoServiceImpl.class);
        //Mockito.when(geo.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl loc = Mockito.spy(LocalizationServiceImpl.class);
        // Mockito.when(loc.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");


        MessageSender messageSender = new MessageSenderImpl(geo, loc);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);


        //act
        String act = messageSender.send(map);
        //assert
        Assertions.assertEquals(expected, act);
    }
}
