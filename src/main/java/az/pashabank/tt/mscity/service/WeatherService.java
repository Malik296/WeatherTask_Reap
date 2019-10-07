package az.pashabank.tt.mscity.service;

import az.pashabank.tt.mscity.model.WeatherDTO;

import java.util.List;

public interface WeatherService {
    List<WeatherDTO> getWeatherByCityId(Long id);

    List<WeatherDTO> getWeatherByDay(String date);

    WeatherDTO getWeatherCities(Long id);
}
