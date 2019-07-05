package com.dharbor.set.dummy.hashtag.rest;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.service.CreateHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rvasquez
 */
@RestController
public class CreateHashtagController {

    @Autowired
    private CreateHashtagService service;

    @RequestMapping(
            value = "/common/tag/add",
            method = RequestMethod.POST
    )
    public ResponseEntity<List<Hashtag>> createHashtag(@RequestBody CreateHashtagRequest request,
                                                       @RequestParam(value = "keyword") String keyword,
                                                       @RequestParam(value = "entityId") String entityId) {
        List<Hashtag> hashtags = service.createHashtag(request.getTag(), keyword, entityId);

        return ResponseEntity.ok(hashtags);
    }

    private static class CreateHashtagRequest {

        private List<String> tag;

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }
    }
}
