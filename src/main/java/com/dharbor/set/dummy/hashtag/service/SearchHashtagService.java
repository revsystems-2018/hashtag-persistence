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
public class SearchHashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public HashtagResponse searchByTag(String tag, String keyword) {
        HashtagResponse data = new HashtagResponse();
        List<Hashtag> hashtags = hashtagRepository.findByTagAndKeyword(tag, keyword);
        data.setData(hashtags);
        return data;
    }
}
