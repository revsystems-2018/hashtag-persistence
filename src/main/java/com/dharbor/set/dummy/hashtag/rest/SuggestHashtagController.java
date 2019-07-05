package com.dharbor.set.dummy.hashtag.rest;

import com.dharbor.set.dummy.hashtag.model.HashtagResponse;
import com.dharbor.set.dummy.hashtag.service.SuggestHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rvasquez
 */
@RestController
public class SuggestHashtagController {

    @Autowired
    private SuggestHashtagService service;

    @RequestMapping(
            value = "/common/getTags/all",
            method = RequestMethod.POST
    )
    public ResponseEntity<HashtagResponse> suggestHashtags(@RequestBody String searchCriteria) {
        HashtagResponse response = service.getHashtagSuggested(searchCriteria);

        return ResponseEntity.ok(response);
    }
}
