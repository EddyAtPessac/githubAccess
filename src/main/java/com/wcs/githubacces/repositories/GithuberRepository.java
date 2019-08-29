package com.wcs.githubacces.repositories;

import com.wcs.githubacces.entities.Githuber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithuberRepository extends JpaRepository<Githuber, Long> {
}
