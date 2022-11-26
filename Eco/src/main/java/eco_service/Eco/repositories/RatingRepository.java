package eco_service.Eco.repositories;

import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
