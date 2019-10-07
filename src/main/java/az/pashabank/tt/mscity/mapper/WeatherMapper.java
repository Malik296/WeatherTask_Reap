package az.pashabank.tt.mscity.mapper;

import az.pashabank.tt.mscity.entity.Weather;
import az.pashabank.tt.mscity.model.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(source = "city.id", target = "cityId")
    WeatherDTO toWeatherDTO (Weather weather);

    List<WeatherDTO> toWeatherDTOs (List<Weather> weathers);

    @Mapping(source = "cityId", target = "city.id")
    Weather toWeatherEntity(WeatherDTO weatherDTO);
}
