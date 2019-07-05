package com.dharbor.set.dummy.hashtag.service;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rvasquez
 */
@Service
public class CreateHashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public List<Hashtag> createHashtag(List<String> tagKeywords, String keyword, String entityId) {

        Hashtag hashtagDB;
        List<Hashtag> hashtags = new ArrayList<>();
        for (String tag : tagKeywords) {
            Hashtag hashtag = hashtagRepository.findOneByTagAndKeyword(tag, keyword);

            if (null == hashtag) {
                hashtagDB = hashtagRepository.insert(buildHashtagToSave(tag, keyword, entityId));
                hashtags.add(hashtagDB);
            } else {
                hashtag.setUsage(hashtag.getUsage() + 1);
                hashtagDB = hashtagRepository.save(hashtag);
                hashtags.add(hashtagDB);
            }
        }

        return hashtags;
    }

    private Hashtag buildHashtagToSave(String tagKeyword, String keyword, String entityId) {
        Hashtag hashtag = new Hashtag();
        hashtag.setTag(tagKeyword);
        hashtag.setUsage(1);
        hashtag.setKeyword(keyword);
        hashtag.setEntityId(entityId);
        hashtag.setCreatedDate(new Date());

        return hashtag;
    }
}
