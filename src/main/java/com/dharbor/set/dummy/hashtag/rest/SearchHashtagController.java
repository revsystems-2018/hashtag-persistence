package com.dharbor.set.dummy.hashtag.rest;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.model.HashtagResponse;
import com.dharbor.set.dummy.hashtag.service.SearchHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rvasquez
 */
@RestController
public class SearchHashtagController {

    @Autowired
    private SearchHashtagService service;

    @RequestMapping(
            value = "/common/tag/search",
            method = RequestMethod.POST
    )
    public ResponseEntity<HashtagResponse> searchByTag(@RequestParam("tag") String tag,
                                               @RequestParam(value = "keyword") String keyword) {
        HashtagResponse response = service.searchByTag(tag, keyword);

        return ResponseEntity.ok(response);
    }
}
