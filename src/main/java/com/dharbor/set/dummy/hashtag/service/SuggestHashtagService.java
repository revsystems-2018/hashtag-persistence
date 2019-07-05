package com.dharbor.set.dummy.hashtag.service;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.model.HashtagResponse;
import com.dharbor.set.dummy.hashtag.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rvasquez
 */
@Service
public class SuggestHashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public HashtagResponse getHashtagSuggested(String searchCriteria) {
        HashtagResponse data = new HashtagResponse();
        List<Hashtag> hashtags = hashtagRepository.findByTagStartingWith(searchCriteria);
        data.setData(hashtags);

        return data;
    }
}
