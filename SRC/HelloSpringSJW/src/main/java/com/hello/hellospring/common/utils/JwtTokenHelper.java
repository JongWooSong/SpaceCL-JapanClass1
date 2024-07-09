package com.hello.hellospring.common.utils;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


/**
 * Provides static methods for creating and verifying access tokens and such. 
 * JWT 토큰을 생성하고 검증하는 클래스
 * 
 * @author SJW
 * @version 1.0
 * @since 2015-11-03
 * 
 * @see https://stormpath.com/blog/jwt-java-create-verify/
 * @see https://github.com/jwtk/jjwt
 */
public class JwtTokenHelper {

	public static final String SUBJECT_SNS_URL = "forSnSUrl";
	public static final String SUBJECT_LOGIN = "forLogined";
	public static final String SUBJECT_COUPON = "forCoupon";
	public static final String SUBJECT_AUTH_EMAIL = "forAuthEmail";

	public static final String ISSUER = "AnissSoft";

	private static final String SIGNING_KEY = "LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";
	public static String AUDIENCE;

	
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SIGNING_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		//Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id)
				.setIssuedAt(now)
				.setSubject(subject)
				.setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		//if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}
	
	public static String createAdminJWT(String id, String issuer, String subject) {

		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(now);

	    calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
	    
        // Get the next day's date and time
        Date nextDayMidnight = calendar.getTime();

		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SIGNING_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		//Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id)
				.setIssuedAt(now)
				.setSubject(subject)
				.setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey)
				.setExpiration(nextDayMidnight);

		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}


	//Sample method to validate and read the JWT
	public static Claims parseJWT(String token) {
		//This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser()         
				.setSigningKey(DatatypeConverter.parseBase64Binary(SIGNING_KEY))
				.parseClaimsJws(token).getBody();
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
		
		return claims;
	}
	

	 /**
     * Parses and validates JWT Token signature.
     * 
     * @throws BadCredentialsException
     * @throws JwtExpiredTokenException
     * 
     */
    public static Jws<Claims> parseClaims(String token) {
        try { 
            return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SIGNING_KEY)).parseClaimsJws(token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            //throw new JwtException("Invalid JWT token: ", ex);
            throw ex;
        } catch (ExpiredJwtException expiredEx) {
            //throw new JwtException("JWT Token expired", expiredEx);
            throw expiredEx;
        }
    }
    
	
}