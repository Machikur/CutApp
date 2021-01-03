package com.urlcuter.cuter.repository;

import com.urlcuter.cuter.link.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LinkRepository extends CrudRepository<Link,Long> {

     List<Link> findAllByUrlContains(String s);

     Optional<Link> findByShortVersion(String shortVersion);

     Optional<Link> findByUrl(String url);

}
