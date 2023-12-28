package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.controller.TestController;
import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.CityWeather;
import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.response.DailyWeatherResponse;
import com.example.weatherwebapp.domain.dto.response.TemperatureData;
import com.example.weatherwebapp.repository.CityRepository;
import com.example.weatherwebapp.repository.CityWeatherRepo;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.CityService;
import com.example.weatherwebapp.service.EmailSenderService;
import com.example.weatherwebapp.service.WeatherService;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private Mapper mapper;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityWeatherRepo cityWeatherRepo;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherIntegration weatherIntegration;

    @Override
    public void fetchWeatherData() {
        // korak 1. dovucem sve gradove iz baze(CityRepository)
        List<City> cities = cityRepository.findAll();
        // korak 2. povucem vremensku prognozu za svaki grad
        for (City city : cities) {
            DailyWeatherResponse dailyWeatherResponse = weatherIntegration.getWeatherForCity(city.getName());
            // korak 3. sacuvam CityWeather za svaki grad i datum.
            CityWeather cityWeather = new CityWeather();
            cityWeather.setCity(city);
            cityWeather.setDate(LocalDate.now());
            cityWeather.setMinTemp(dailyWeatherResponse.getMinTemp());
            cityWeather.setMaxTemp(dailyWeatherResponse.getMaxTemp());
            cityWeather.setAvgTemp(dailyWeatherResponse.getAvgTemp());
            cityWeatherRepo.save(cityWeather);
        }

        // korak 4. napravim neki testController i probam

    }

    @Override
    public void sendDailyWeather() {
        // korak 1: pronadjem sve users
        List<User> users = userRepository.findAll();
        // korak 2: uzimam trenutni datum
        LocalDate currentDate = LocalDate.now();

        // korak 3: za svakog usera, pokupim informacije koje ga zanimaju
        for(User user: users) {
            String userEmail = user.getEmail();
            // podaci o vremenu koji ce biti poslati
            List<TemperatureData> data = new ArrayList<>();
            for(Subscription subscription: user.getSubscriptions()) {
                // dohvatam prognozu za grad iz subskripcije
                String cityName = subscription.getCity().getName();
                TemperatureData cityTemperature = fetchDataByCityAndDate(cityName, currentDate);
                data.add(cityTemperature);
            }

            System.out.println("=================================");
            System.out.println("Saljem mail na adresu: "+userEmail);
            System.out.println("Sa podacima:");
            for(TemperatureData temperatureData: data) {
                System.out.println("Grad: "+temperatureData.getCityName()+", avg: "+temperatureData.getAvgTemp());
            }
            System.out.println("=================================");

            // StringBuilder, konkateniranjem


            emailSenderService.sendEmail(userEmail, "Daily weather", "TODO");
        }

    }

    @Override
    public TemperatureData fetchDataByCityAndDate(String cityName, LocalDate localDate) {

        CityWeather cw = cityWeatherRepo.findByCity_NameAndDate(cityName, localDate);
        TemperatureData temperature = new TemperatureData();
        temperature.setCityName(cityName);
        temperature.setMinTemp(cw.getMinTemp());
        temperature.setMaxTemp(cw.getMaxTemp());
        temperature.setAvgTemp(cw.getAvgTemp());
        System.out.println(temperature);

        return temperature;

    }





}




