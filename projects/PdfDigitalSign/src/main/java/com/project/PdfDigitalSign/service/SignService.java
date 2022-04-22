package com.project.PdfDigitalSign.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.PdfDigitalSign.model.SignProcess;
import com.project.PdfDigitalSign.repository.SignProcessRepository;

@Named
public class SignService {

	private static final Logger logger = LogManager.getLogger(SignService.class);

	@Inject
	private SignProcessRepository repository;

	public List<SignProcess> allSignes() {
		logger.info("begin allSignes()");
		List<SignProcess> signPocesses = repository.findAll();
		logger.info("list size: {}", signPocesses.size());
		return signPocesses;
	}
	
	public void save(SignProcess sign) {
		logger.info("Save sign with FileName {}", sign.getFileName());
		repository.save(sign);
	}
	
	public Optional<SignProcess> getSignById(Long id) {
		logger.info("getSignById {}", id);
		return repository.findById(id);
	}
}