package az.pashabank.tt.mscity.service.impl;

import az.pashabank.tt.mscity.mapper.WeatherMapper;
import az.pashabank.tt.mscity.model.WeatherDTO;
import az.pashabank.tt.mscity.repository.WeatherRepository;
import az.pashabank.tt.mscity.service.WeatherService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDTO> getWeatherByCityId(Long cityId) {
        return WeatherMapper.INSTANCE.toWeatherDTOs(weatherRepository.findAllByCityId(cityId));
    }

    @Override
    public List<WeatherDTO> getWeatherByDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return WeatherMapper.INSTANCE.toWeatherDTOs(weatherRepository.findAllWithDate(localDate));
    }

    @Override
    public WeatherDTO getWeatherCities(Long id) {
        LocalDate date = LocalDate.now();
        return WeatherMapper.INSTANCE.toWeatherDTO(weatherRepository.findAllWithCityAdnDate(id, date));
    }
}
