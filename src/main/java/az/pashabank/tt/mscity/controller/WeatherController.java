package az.pashabank.tt.mscity.controller;

import az.pashabank.tt.mscity.model.WeatherDTO;
import az.pashabank.tt.mscity.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("weather")
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("city/{id}")
    public List<WeatherDTO> getWeatherByCityId(@PathVariable Long id) {
        logger.info("Get Request: Weather by city id");
        return weatherService.getWeatherByCityId(id);
    }

    @GetMapping("day/{date}")
    public List<WeatherDTO> getWeatherByDay(@PathVariable String date) {
        logger.info("Get Request: Weather by day");
        return weatherService.getWeatherByDay(date);
    }

    @GetMapping("service/{id}")
    public WeatherDTO getWeatherCities(@PathVariable Long id) {
        return weatherService.getWeatherCities(id);
    }
}
