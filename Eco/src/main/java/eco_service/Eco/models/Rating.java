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
@Table(name = "rating",schema = "public")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Waste waste;

}
