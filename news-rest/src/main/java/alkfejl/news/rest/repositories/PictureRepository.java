package alkfejl.news.rest.repositories;

import alkfejl.news.rest.entities.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Integer> {
    
}
