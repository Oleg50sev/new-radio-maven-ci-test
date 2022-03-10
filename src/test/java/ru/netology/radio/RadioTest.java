package ru.netology.radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    //Тест на ввод номера станции вручную при количестве станций, заданных пользователем
    @CsvSource(value = {"middleStation, 25, 25",
            "nearLastStation, 48, 48",
            "lastStation, 49, 49",
            "overLastStation, 50, 0",
            "secondStation, 0, 0",
            "overSecondStation, 1, 1",
            "minusStation, -1, 0"})
    void setCurrentNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio1 = new Radio(50,49);

        radio1.setCurrentNumberStation(currentNumberStation);

        int actual = radio1.getCurrentNumberStation();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    // Тест на переключение вверх на одну станцию при нажатии на кнопку Next
    // (количество станций и максимальный номер станции заданы пользователем)
    @CsvSource(value = {"middleStation, 59, 60",
            "nearLastStation, 89, 90",
            "lastStation, 90, 0",
            "secondStation, 0, 1",
            "overSecondStation, 1, 2"})
    void nextNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio1 = new Radio(91,90);

        radio1.setCurrentNumberStation(currentNumberStation);

        radio1.nextNumberStation();

        int actual = radio1.getCurrentNumberStation();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    // Тест на переключение вверх на одну станцию вниз при нажатии на кнопку Prev
    // (количество станций и максимальный номер станции по умолчанию)
    @CsvSource(value = {"middleStation, 5, 4",
            "nearLastStation, 8, 7",
            "lastStation, 9, 8",
            "secondStation, 0, 9",
            "overSecondStation, 1, 0"})
    void prevNumberStation(String testName, int currentNumberStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentNumberStation(currentNumberStation);

        radio.prevNumberStation();

        int actual = radio.getCurrentNumberStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    //Тест на увеличение громкости на одну градацию при нажатии на кнопку +
    @CsvSource(value = {"middleStation, 5, 6",
            "nearLastStation, 99, 100",
            "lastStation, 100, 100",
            "secondStation, 0, 1",
            "overSecondStation, 1, 2"})
    void increaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.increaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    //Тест на уменьшение громкости на одну градацию при нажатии на кнопку -
    @CsvSource(value = {"middleStation, 5, 4",
            "nearLastStation, 99, 98",
            "lastStation, 100, 99",
            "secondStation, 0, 0",
            "overSecondStation, 1, 0"})
    void decreaseVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}