package com.project.PdfDigitalSign;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.PdfDigitalSign.model.SignProcess;
import com.project.PdfDigitalSign.service.SignGenService;
import com.project.PdfDigitalSign.service.SignService;

@SpringBootTest
public class SignServiceTest {

	private static final String TYPE = "application/octet-stream";
	private static final String SIGN_ID_SIGNED = "3";
	private static final String SIGN_ID_UNSIGNED = "2";
	private static final Logger logger = LogManager.getLogger(SignServiceTest.class);
	private static SignProcess signProc;

	@Inject
	SignGenService signGenServ;

	@Inject
	SignService service;

	@BeforeAll
	static void setup() {
		logger.info("==================LOADING BEGIN=====================");
	}

	@AfterAll
	static void done() {
		logger.info("=================SHUTDOWN FINISHED==================");
	}

	@Test
	void generateKeyPairTest() {
		logger.info("****************************************************");
		logger.info("*************Begin generateKeyPairTest**************");
		logger.info("****************************************************");
		logger.info("");
		assertTrue(notEmptyGeneratedKeyPairZipContent());
		assertTrue(filesForVeryfyTestIsPresent(SIGN_ID_SIGNED));
		assertTrue(filesVerifyed());
		assertTrue(filesForVeryfyTestIsPresent(SIGN_ID_UNSIGNED));
		assertFalse(filesVerifyed());
		logger.info("");
		logger.info("****************************************************");
		logger.info("************Finish generateKeyPairTest**************");
		logger.info("****************************************************");
	}

	private boolean filesVerifyed() {
		logger.info("=======Begin  filesVerifyed========================");
		boolean isVerify = false;
		try {
			signGenServ.setPublicKey(
					new ByteArrayUploadedFile(signProc.getPublicKeyData(), signProc.getPublicKeyName(), TYPE));
			signGenServ.setSignVerify(new ByteArrayUploadedFile(signProc.getSignature(), signProc.getSignName(), TYPE));
			signGenServ.setSignData(new ByteArrayUploadedFile(signProc.getFileData(), signProc.getFileName(), TYPE));
			isVerify = signGenServ.verifyData();
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException
				| NullPointerException e) {
			logger.error("VERIFY ERROR check files data");
		}
		logger.info("sign verify result: " + isVerify);
		logger.info("=======Finish filesVerifyed========================");
		return isVerify;
	}

	private boolean filesForVeryfyTestIsPresent(String signId) {
		logger.info("=======Begin  filesForVeryfyTestIsPresent==========");
		Optional<SignProcess> signProcList = service.getSignById(Long.valueOf(signId));
		signProc = signProcList.get();
		logger.info("Sign process FielName: {}", signProc.getFileName());
		logger.info("Sign process SignName: {}", signProc.getSignName());
		logger.info("Sign process PublicKeyName: {}", signProc.getPublicKeyName());
		logger.info("=======Finish filesForVeryfyTestIsPresent==========");
		return !Strings.isNullOrEmpty(signProc.getFileData().toString());
	}

	@SuppressWarnings("resource")
	private boolean notEmptyGeneratedKeyPairZipContent() {
		logger.info("=======Begin  generatedKeyPair=====================");
		signGenServ.generateKeyPair();
		int contentSize = 0;
		try {
			InputStream contentSize_stream = signGenServ.getKeyPairZip().getStream();
			contentSize = readAllBytes(contentSize_stream).length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Generated file Name {}", signGenServ.getKeyPairZip().getName());
		logger.info("=======Finish generatedKeyPair=====================");
		return contentSize != 0;
	}
	
	public static byte[] readAllBytes(InputStream inputStream) throws IOException {
	    final int bufLen = 1024;
	    byte[] buf = new byte[bufLen];
	    int readLen;
	    IOException exception = null;

	    try {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
	            outputStream.write(buf, 0, readLen);

	        return outputStream.toByteArray();
	    } catch (IOException e) {
	        exception = e;
	        throw e;
	    } finally {
	        if (exception == null) inputStream.close();
	        else try {
	            inputStream.close();
	        } catch (IOException e) {
	            exception.addSuppressed(e);
	        }
	    }
	}

}