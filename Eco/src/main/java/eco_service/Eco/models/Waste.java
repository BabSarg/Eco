package eco_service.Eco.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "waste",schema = "public")
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private boolean latitude;

    @ManyToOne
    @JoinColumn(name = "eco_service_id")
    private EcoService ecoService;

    @ManyToOne
    @JoinColumn(name = "waste_address_id")
    private WasteAddress wasteAddress;

    @Column(name = "photo")
    private String photo;
}
