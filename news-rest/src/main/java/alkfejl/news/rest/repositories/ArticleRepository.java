package alkfejl.news.rest.repositories;

import alkfejl.news.rest.entities.Article;
import alkfejl.news.rest.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    public Iterable<Article> findAllByUser(User user);
}
