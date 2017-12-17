package game.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import game.model.Content;

public interface ContentRepository extends MongoRepository<Content, String> {

    public List<Content> findContentByGeokey(String geokey);

}
