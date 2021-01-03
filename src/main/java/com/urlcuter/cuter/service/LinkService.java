package com.urlcuter.cuter.service;

import com.urlcuter.cuter.link.Link;
import com.urlcuter.cuter.link.LinkDto;
import com.urlcuter.cuter.link.LinkMapper;
import com.urlcuter.cuter.linkexception.WrongShortVersionExeption;
import com.urlcuter.cuter.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Random;

@Service
public class LinkService {


    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;

    @Autowired
    public LinkService(LinkRepository linkRepository, LinkMapper linkMapper) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
    }

    public LinkDto findOrCreateNewLink(String url) {
        Optional<Link> link = linkRepository.findByUrl(url);
        return linkMapper.mapToDto(link.orElseGet(() -> linkRepository.save(new Link(url, randomStringGenerator()))));
    }

    public String getUrlByShortVersion(String shortVersion) throws WrongShortVersionExeption, MalformedURLException, URISyntaxException {
        Optional<Link> shortLink = linkRepository.findByShortVersion(shortVersion);
        if (shortLink.isPresent()) {
            String url = shortLink.get().getUrl();
            return checkUrl(url);
        } else throw new WrongShortVersionExeption("Wrong Link");
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
            r.append(random.nextInt(100));
        }
        return r.toString();
    }

    private String checkUrl(String url) {
        String start = url.substring(0, 3);
        if (!start.equals("htt") && !start.equals("www")) {
            return "https://www." + url;
        } else if (start.equals("www")) {
            return "https://" + url;
        } else return url;
    }
}
