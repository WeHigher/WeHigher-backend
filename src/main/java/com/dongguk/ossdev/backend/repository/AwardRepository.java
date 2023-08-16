package com.dongguk.ossdev.backend.repository;

import com.dongguk.ossdev.backend.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
}
