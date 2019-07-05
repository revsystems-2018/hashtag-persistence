package com.dharbor.set.dummy.hashtag.repository;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @author rvasquez
 */
public interface HashtagRepository extends MongoRepository<Hashtag, String> {

    @ApiOperation(
            value = "findByTagStartingWith"
    )
    List<Hashtag> findByTagStartingWith(@RequestParam String tag);

    @ApiOperation(
            value = "findByTagAndKeyword"
    )
    List<Hashtag> findByTagAndKeyword(@RequestParam String Tag, String keyword);

    @ApiOperation(
            value = "findByTagAndKeywordAndEntityId"
    )
    Hashtag findOneByTagAndKeyword(@RequestParam String tag, String keyword);

    @ApiOperation(
            value = "findByKeywordAndEntityId"
    )
    List<Hashtag> findByKeywordAndEntityId(@RequestParam String keyword, @RequestParam String entityId);

    @ApiOperation(
            value = "findById"
    )
    Optional<Hashtag> findById(@RequestParam String id);
}
