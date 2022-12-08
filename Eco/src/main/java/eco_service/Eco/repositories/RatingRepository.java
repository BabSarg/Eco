package eco_service.Eco.repositories;

import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT * from Rating R WHERE R.ecoService.id = :ecoServiceId")
    List<Rating> findByEcoService_Id(Long ecoServiceId);
    @Query("SELECT * from Rating R WHERE R.waste.id = :wasteId")
    List<Rating> findByWaste_Id(Long wasteId);


}
