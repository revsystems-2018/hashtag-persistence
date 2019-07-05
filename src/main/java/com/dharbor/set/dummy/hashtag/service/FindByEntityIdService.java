package com.dharbor.set.dummy.hashtag.service;

import com.dharbor.set.dummy.hashtag.model.Hashtag;
import com.dharbor.set.dummy.hashtag.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class FindByEntityIdService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public List<Hashtag> getHashtagByTag(String keyword, String entityId) {

        return hashtagRepository.findByKeywordAndEntityId(keyword, entityId);
    }
}
