package com.dharbor.set.dummy.hashtag.service;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author rveizaga
 */
@Service
public class removeHashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public Hashtag deleteHashtag(String tag, String keyword, String entityId) {

        Hashtag hashtagDB;
        Hashtag hashtag = hashtagRepository.findOneByTagAndKeyword(tag, keyword);

        if (null == hashtag) {
            hashtagDB = hashtagRepository.insert(buildHashtagToSave(tag, keyword, entityId));
        } else {
            hashtag.setUsage(hashtag.getUsage() - 1);
            hashtagDB = hashtagRepository.save(hashtag);
        }

        return hashtagDB;
    }

    private Hashtag buildHashtagToSave(String tagKeyword, String keyword, String entityId) {
        Hashtag hashtag = new Hashtag();
        hashtag.setTag(tagKeyword);
        hashtag.setUsage(1);
        hashtag.setEntityId(entityId);
        hashtag.setKeyword(keyword);
        hashtag.setCreatedDate(new Date());

        return hashtag;
    }
}
