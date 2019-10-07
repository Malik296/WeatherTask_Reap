package az.pashabank.tt.mscity.job;

import az.pashabank.tt.mscity.entity.Weather;
import az.pashabank.tt.mscity.mapper.WeatherMapper;
import az.pashabank.tt.mscity.model.WeatherDTO;
import az.pashabank.tt.mscity.repository.WeatherRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class WeatherGenerator {
    private final WeatherRepository weatherRepository;
    private Random random = new Random();
    private LocalDate localDate = LocalDate.now();

    public WeatherGenerator(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Scheduled(fixedDelay = 5000)
    void weatherGenerator() {
        WeatherDTO weatherDTO = new WeatherDTO();
        localDate = localDate.plusDays(1);
        weatherDTO.setDate(localDate);
        for (int i = 1; i <= 5; i++) {
            int degree = random.nextInt(50);
            weatherDTO.setCityId(i);
            weatherDTO.setDegrees(degree);
            Weather weather = WeatherMapper.INSTANCE.toWeatherEntity(weatherDTO);
            weatherRepository.save(weather);
        }
        localDate = localDate.plusDays(1);
    }
}
