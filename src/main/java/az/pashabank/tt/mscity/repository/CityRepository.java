package az.pashabank.tt.mscity.repository;

import az.pashabank.tt.mscity.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
