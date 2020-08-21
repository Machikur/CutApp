package com.urlcuter.cuter.repository;

import com.urlcuter.cuter.link.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LinkRepository extends CrudRepository<Link,String> {

     Link findByShortVersion(String shortVersion);
}
