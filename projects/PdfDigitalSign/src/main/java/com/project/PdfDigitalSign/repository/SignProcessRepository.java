package com.project.PdfDigitalSign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.PdfDigitalSign.model.SignProcess;

public interface SignProcessRepository extends JpaRepository<SignProcess, Long> {

}