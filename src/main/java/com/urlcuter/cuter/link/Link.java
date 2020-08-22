package com.urlcuter.cuter.link;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Link {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(name="url",unique =true)
    private String url;

    @NotNull
    @Column(name="shortVersion",unique = true)
    private String shortVersion;

    public Link(String url,String shortVersion){
        this.url=url;
        this.shortVersion=shortVersion;
    }

}
