package ru.netology.radio;

public class Radio {
    private int quantityStations = 10; // количество станций по умолчанию
    private int currentNumberStation; // текущий номер станции
    private int currentVolume; // текущая громкость
    private int minNumberStation = 0; // минимальный номер станции
    private int maxNumberStation;
    private int minVolume = 0; // минимальная громкость
    private int maxVolume = 100; // максимальная громкость

    // конструктор для установки количества станций пользователем
    public Radio(int quantityStations) {
        this.quantityStations = quantityStations;
    }

    // конструктор для установки количества станций и максимального номера станции по умолчанию
    public Radio() {
    }

    public int getMaxNumberStation() {
        return maxNumberStation = quantityStations - 1;
    }

    public int getCurrentNumberStation() {
        return currentNumberStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    public void setCurrentNumberStation(int currentNumberStation) {
        if (currentNumberStation > maxNumberStation) {
            return;
        }
        if (currentNumberStation < minNumberStation) {
            return;
        }
        this.currentNumberStation = currentNumberStation;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void nextNumberStation() {
        if (currentNumberStation == maxNumberStation) {
            currentNumberStation = minNumberStation;
            return;
        }
        currentNumberStation++;
    }

    public void prevNumberStation() {
        if (currentNumberStation == minNumberStation) {
            currentNumberStation = maxNumberStation;
            return;
        }
        currentNumberStation--;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

}
