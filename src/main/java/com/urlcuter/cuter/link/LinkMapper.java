package com.urlcuter.cuter.link;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {
    @Value("${base.url.baseUrl}")
    private String baseUrl;

    public LinkDto mapToDto(Link link){
        return new LinkDto(link.getUrl(),baseUrl+link.getShortVersion());
    }

}
