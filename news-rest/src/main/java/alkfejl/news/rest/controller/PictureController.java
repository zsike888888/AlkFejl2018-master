package alkfejl.news.rest.controller;

import alkfejl.news.rest.entities.Picture;
import alkfejl.news.rest.repositories.PictureRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private PictureRepository pictureRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Picture>> getAll() {
        return ResponseEntity.ok(pictureRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Picture> get(@PathVariable Integer id) {
        Optional<Picture> picture = pictureRepository.findById(id);
        if (picture.isPresent()) {
            return ResponseEntity.ok(picture.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Picture> post(@RequestBody Picture label) {
        Picture savedPicture = pictureRepository.save(label);
        return ResponseEntity.ok(savedPicture);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Picture> put(@RequestBody Picture picture, @PathVariable Integer id) {
        Optional<Picture> oPicture = pictureRepository.findById(id);
        if (oPicture.isPresent()) {
            picture.setPicture_id(id);
            return ResponseEntity.ok(pictureRepository.save(picture));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Picture> oPicture = pictureRepository.findById(id);
        if (oPicture.isPresent()) {
            pictureRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
