package org.cinematickets.repository;

import org.cinematickets.dto.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator, String> {
}
