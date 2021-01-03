package com.urlcuter.cuter.link;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Link {

    @NotNull
    @Column(name="url",unique =true)
    private String url;

    @Column(name="shortVersion",unique = true)
    private String shortVersion=null;

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    public Link(String url,String shortVersion){
        this.url=url;
        this.shortVersion=shortVersion;
    }

}
