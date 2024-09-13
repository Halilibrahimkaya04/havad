package org.hdwork.havad.Repository;

import org.hdwork.havad.model.WeatherDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface WeatherRepository extends MongoRepository<WeatherDocument, String> {
    Optional<WeatherDocument> findByName(String name);
}
