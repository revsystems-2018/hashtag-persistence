package com.dharbor.set.dummy.hashtag.rest;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.service.removeHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rveizaga
 */
@RestController
public class removeHashtagController {

    @Autowired
    private removeHashtagService service;

    @RequestMapping(
            value = "/common/tag/remove",
            method = RequestMethod.POST
    )
    public ResponseEntity<Hashtag> deleteHashtag(@RequestParam(value = "tag") String tag,
                                                 @RequestParam(value = "keyword") String keyword,
                                                 @RequestParam(value = "entityId") String entityId) {
        Hashtag hashtags = service.deleteHashtag(tag, keyword, entityId);

        return ResponseEntity.ok(hashtags);
    }
}
