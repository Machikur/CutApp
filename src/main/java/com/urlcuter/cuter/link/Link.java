package com.urlcuter.cuter.link;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name="link")
@Getter
public class Link {

    @Id
    @Column(name="url")
    private String url;

    @Column(name="shortVersion")
    private String shortVersion;

}
