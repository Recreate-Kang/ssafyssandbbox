package com.ssafy.sandbox.smtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmtpRepository extends JpaRepository<com.ssafy.sandbox.smtp.dto.Todo, Integer> {

}
