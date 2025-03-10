package com.lc.backend_personal_finance_tracker.repo;

import com.lc.backend_personal_finance_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
