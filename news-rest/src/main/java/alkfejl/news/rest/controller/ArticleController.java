package alkfejl.news.rest.controller;

import alkfejl.news.rest.entities.Article;
import alkfejl.news.rest.entities.User;
import alkfejl.news.rest.repositories.ArticleRepository;
import alkfejl.news.rest.repositories.UserRepository;
import alkfejl.news.rest.security.AuthenticatedUser;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("/{id}")
    public ResponseEntity<Article> get(@PathVariable Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return ResponseEntity.ok(article.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Article> post(@RequestBody Article article) {
        User user = authenticatedUser.getUser();
        article.setAuthor(user);
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.ok(savedArticle);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Article> delete
            (@PathVariable Integer id) {
        Optional<Article> oArticle = articleRepository.findById(id);
        if (oArticle.isPresent()) {
            articleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
