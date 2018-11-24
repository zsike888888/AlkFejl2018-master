package alkfejl.news.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Article{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer article_id;
    
    @Column(nullable = false)
    private String title;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User author;
    
    @Column(updatable = false)
    @CreationTimestamp
    private Date date;
    
    @Column
    @NotNull
    private String summary;
    
    @Column
    @NotNull
    private String full_article;
    
    @Column(nullable = false)
    private boolean isLeadingArticle;

}
