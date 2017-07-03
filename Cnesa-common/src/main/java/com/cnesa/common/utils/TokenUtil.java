package com.cnesa.common.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by shangpeibao on 16/12/20.
 *
 *
 */
public class TokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
    private static final String issuer = "http://www.cnesa.cn/";
    private static final String secret = "it is the secret used for signing azaazafighting";


    public static String signJWT(String uid, String email, Set<String> urls){

        final long iat = System.currentTimeMillis() / 1000L; // issued at claim
        final long exp = iat + 7L * 24L * 3600L * 1000L; // expires claim. In this case the token expires in 1800 seconds (7 days)
//        final long exp = iat + 1800L; // expires claim. In this case the token expires in 1800 seconds

        final JWTSigner signer = new JWTSigner(secret);
        final HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("iss", issuer);
        claims.put("exp", exp);
        claims.put("iat", iat);
        claims.put("uid", uid);
        claims.put("email", email);
        claims.put("resources", urls);

        final String jwt = signer.sign(claims);

        return jwt;
    }

    public static Boolean verifyJWT(String token){
        try {
            final JWTVerifier verifier = new JWTVerifier(secret);
            final Map<String, Object> claims= verifier.verify(token);
            String issuer = (String)claims.get("iss");
//            Long expire = (Long)claims.get("exp");
//            Integer iat = (Integer) claims.get("iat");
            String uid = (String)claims.get("uid");
            String email = (String)claims.get("email");

            return true;
        } catch (Exception e) {
            // Invalid Token
            logger.error("verifyJWT:{}", e.getMessage());
        }
        return false;
    }

    public static String getUserIdByToken(String token){
        try {
            final JWTVerifier verifier = new JWTVerifier(secret);
            final Map<String, Object> claims= verifier.verify(token);

            String uid = claims.get("uid").toString();
            return uid;
        } catch (Exception e) {
            // Invalid Token
            logger.error("getUserIdByToken:{}", e.getMessage());
        }
        return null;
    }

    public static List<String> getResourcesByToken(String token) {
        try {
            final JWTVerifier verifier = new JWTVerifier(secret);
            final Map<String, Object> claims= verifier.verify(token);

            List<String> resources = (List<String>) claims.get("resources");
            return resources;
        } catch (Exception e) {
            // Invalid Token
//            e.printStackTrace();
            logger.error("getResourcesByToken:{}", e.getMessage());
        }
        return null;
    }

    public static Map<String, Object> getMapByToken(String token) {
        try {
            final JWTVerifier verifier = new JWTVerifier(secret);
            final Map<String, Object> claims= verifier.verify(token);
            return claims;
        } catch (Exception e) {
            // Invalid Token
//            e.printStackTrace();
            logger.error("getMapByToken:{}", e.getMessage());
        }
        return null;
    }

}
