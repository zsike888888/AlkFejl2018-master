package alkfejl.news.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Picture{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer picture_id;
    
    @Column(nullable = false)
    private String url;
    
    @ManyToMany(mappedBy = "pictures")
    @JsonIgnore
    private List<Article> article;
}
