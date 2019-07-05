package com.dharbor.set.dummy.hashtag.rest;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.service.FindByEntityIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
public class FindByEntityController {
    @Autowired
    private FindByEntityIdService service;

    @RequestMapping(
            value = "/common/tag/get",
            method = RequestMethod.POST
    )
    public ResponseEntity<List<Hashtag>> loadHashtagByEntity(@RequestParam(value = "keyword") String keyword,
                                                             @RequestParam(value = "entityId") String entityId) {
        List<Hashtag> hashtags = service.getHashtagByTag(keyword, entityId);

        return ResponseEntity.ok(hashtags);
    }
}
