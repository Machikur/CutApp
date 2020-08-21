package com.urlcuter.cuter.service;

import com.urlcuter.cuter.link.Link;
import com.urlcuter.cuter.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public Link saveLink(String url) {
        if (linkRepository.findById(url).isPresent()) {
            return linkRepository.findById(url).get();
        } else {
            return linkRepository.save(new Link(url, randomStringGenerator()));
        }
    }

    public String getUrlByShortVersion(String shortVersion) {
        return linkRepository.findByShortVersion(shortVersion).getUrl();
    }


    private String randomStringGenerator() {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(7);
        for (int i = 0; i < 3; i++) {
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char) nextRandomChar);
            r.append(random.nextInt(20));
        }
        return r.toString();
    }
}
