package az.pashabank.tt.mscity.repository;

import az.pashabank.tt.mscity.entity.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends PagingAndSortingRepository<Weather, Long> {
    List<Weather> findAllByCityId(Long id);

    @Query("select w from Weather w where w.date = :date")
    List<Weather> findAllWithDate(@Param("date") LocalDate date);

    @Query("select w from Weather w where w.id = ?1 and w.date =  ?2")
    Weather findAllWithCityAdnDate( Long id, LocalDate date);

}
