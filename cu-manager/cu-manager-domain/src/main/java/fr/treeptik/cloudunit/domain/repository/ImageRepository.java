package fr.treeptik.cloudunit.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import fr.treeptik.cloudunit.domain.core.Image;

public interface ImageRepository extends Repository<Image, String> {
    Optional<Image> findOne(String id);
    Optional<Image> findByName(String name);
    List<Image> findAll();

    Image save(Image image);
    
    void delete(Image image);
    void deleteAll();
}
