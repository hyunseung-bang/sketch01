package com.sketch01.core.domain.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyRepository extends JpaRepository<Many, Long> {

}
