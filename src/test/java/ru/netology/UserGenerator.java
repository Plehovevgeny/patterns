package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UserGenerator {

    public static DataUser generateUser(int changeDay) {
        String city = generateCity();
        String date = generateDate(changeDay);
        String name = generateName();
        String phone = generatePhone();
        DataUser user = new DataUser(city, date, name, phone);
        return user;
    }

    public static String generateCity() {
        String[] cities = new String[]{
                "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский",
                "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск",
                "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга",
        };
        Faker faker = new Faker();
        int index = faker.number().numberBetween(0, cities.length -1);
        String city = cities[index];
        return city;
    }

    public static String generateDate(int changeDays){
        String meetDay = LocalDate.now().plusDays(changeDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return meetDay;
    }

    public static String generateName(){
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }
    public static String generatePhone(){
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
}
