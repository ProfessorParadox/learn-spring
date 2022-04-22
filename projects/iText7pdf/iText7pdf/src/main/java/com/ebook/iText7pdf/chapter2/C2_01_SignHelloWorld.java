package com.ebook.iText7pdf.chapter2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;

public class C2_01_SignHelloWorld {
	public static final String DEST = "./target/signatures/chapter02/";

	public static final String KEYSTORE = "./src/test/resources/encryption/mykeystoreone";
	public static final String SRC = "./src/test/resources/pdfs/hello.pdf";

	public static final char[] KSPASSWORD = "mykeystoreonepass".toCharArray();
	public static final char[] KEYPASSWORD = "mykeyonepass".toCharArray();

	public static final String[] RESULT_FILES = new String[] { "hello_signed1.pdf", "hello_signed2.pdf",
			"hello_signed3.pdf", "hello_signed4.pdf" };

	public void sign(String src, String dest, Certificate[] chain, PrivateKey pk, String digestAlgorithm,
			String provider, PdfSigner.CryptoStandard signatureType, String reason, String location)
			throws GeneralSecurityException, IOException {
		PdfReader reader = new PdfReader(src);
		FileOutputStream os = new FileOutputStream(dest);
		PdfSigner signer = new PdfSigner(reader,os , true);

		// Create the signature appearance
		Rectangle rect = new Rectangle(336, 648, 200, 100);
		PdfSignatureAppearance appearance = signer.getSignatureAppearance();
		appearance.setReason(reason).setLocation(location)

				// Specify if the appearance before field is signed will be used
				// as a background for the signed field. The "false" value is the default value.
				.setReuseAppearance(false).setPageRect(rect).setPageNumber(1);
		signer.setFieldName("sig");

		IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
		IExternalDigest digest = new BouncyCastleDigest();

		// Sign the document using the detached mode, CMS or CAdES equivalent.
		signer.signDetached(digest, pks, chain, null, null, null, 0, signatureType);
	
		os.close();
		reader.close();
	}

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		File file = new File(DEST);
		file.mkdirs();

		BouncyCastleProvider provider = new BouncyCastleProvider();
		Security.addProvider(provider);
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(new FileInputStream(KEYSTORE), KSPASSWORD);
		String alias = ks.aliases().nextElement();
		PrivateKey pk = (PrivateKey) ks.getKey(alias, KEYPASSWORD);
		Certificate[] chain = ks.getCertificateChain(alias);

		C2_01_SignHelloWorld app = new C2_01_SignHelloWorld();
		app.sign(SRC, DEST + RESULT_FILES[0], chain, pk, DigestAlgorithms.SHA256, provider.getName(),
				PdfSigner.CryptoStandard.CMS, "Test 1- CMS with SHA256", "ChandigarhUT");
		app.sign(SRC, DEST + RESULT_FILES[1], chain, pk, DigestAlgorithms.SHA512, provider.getName(),
				PdfSigner.CryptoStandard.CMS, "Test 2- CMS with SHA512", "ChandigarhUT");
		app.sign(SRC, DEST + RESULT_FILES[2], chain, pk, DigestAlgorithms.SHA256, provider.getName(),
				PdfSigner.CryptoStandard.CADES, "Test 3-  CADES with SHA256", "ChandigarhUT");
		/*app.sign(SRC, DEST + RESULT_FILES[3], chain, pk, DigestAlgorithms.RIPEMD160, provider.getName(),
				PdfSigner.CryptoStandard.CADES, "Test 4-  CADES with RIPEMD160", "ChandigarhUT");
				*/
	}
}
