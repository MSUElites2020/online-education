package com.online_education.user.command;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.dao.student.Student;
import com.online_education.dao.student.StudentDao;
import com.online_education.model.ApiGatewayRequest;
import com.online_education.model.ApiGatewayResponse;
import org.apache.commons.codec.binary.Base64;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther fansun
 */

@Slf4j
public class UserGetCommand {
  private ObjectMapper objectMapper;
  private StudentDao studentDao;

  @Inject
  public UserGetCommand(ObjectMapper objectMapper, StudentDao studentDao) {
    this.objectMapper = objectMapper;
    this.studentDao = studentDao;
  }

  public ApiGatewayResponse execute(ApiGatewayRequest request) throws Exception {
    String userName = request.queryStringParameters.get("userName");
    log.info("Get userName: " + userName);
    String auth = request.queryStringParameters.get("token");
    log.info("Get token: " + auth);
    if (!checkAuth(auth, userName)) {
      return new ApiGatewayResponse(401, "User " + userName + "is not permitted to check other user's info");
    }
    log.info("Retrieving student " + userName);
    Student student = studentDao.get(userName);
    return new ApiGatewayResponse(200, "return item is : " + objectMapper.writeValueAsString(student));
  }

  private boolean checkAuth(String auth, String userName) throws Exception {
    try {
      String publicKeyPem = "-----BEGIN PUBLIC KEY-----\n"
          + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw1VjeUPpZ4/SEtsWzZY1\n"
          + "RZ8Bdw4aPsOmn+atz+sEdloxg0uxJDSMoz9GPC3CiUHJfwKvYZhR0jOV24ajgJzZ\n"
          + "y4BowY09y5Bc8Qw/l9/lJ8Jk0YuU1DGxVlx6kSCI7SLeCVNRm2JyDhXUjCXC/n9B\n"
          + "Ol/plX9YIMv9nZaywwsJL0W53+TfoCpKXDcGau+sEaDZNYQ4HvX+Y77LRBgY1San\n"
          + "/SyBKz0cYrgykAtwQfQs0ZMcIx3ly4nDP7IfbnkmtNqvbaC1Qtdb6mFB7PAGdFeX\n"
          + "r2Mb9V1mZyq5NiaLBqhT6A3uFST0Q0zW21bHMqB7plVgdlAK2mbnL+/VEmtnE7jk\n"
          + "aQIDAQAB\n"
          + "-----END PUBLIC KEY-----";
      Claims claims = Jwts.parser()
          .setSigningKey(readPublicKey(publicKeyPem))
          .parseClaimsJws(auth).getBody();
      log.info("Parse claims " + claims.toString());

      if (claims.get("cognito:username").toString().equals(userName)) {
        log.info("Parse claims cognito:username" + claims.get("cognito:username"));
        return true;
      } else {
        log.info("Parse claims cognito:username" + claims.get("cognito:username"));
        return false;
      }
    } catch(Exception e) {
      log.info("Get JWT parse exception " + e.getMessage());
      throw e;
    }
  }

  public static RSAPublicKey readPublicKey(String keyString) throws Exception {
    String publicKeyPEM = keyString
        .replace("-----BEGIN PUBLIC KEY-----", "")
        .replaceAll(System.lineSeparator(), "")
        .replace("-----END PUBLIC KEY-----", "");

    byte[] encoded = Base64.decodeBase64(publicKeyPEM);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
    return (RSAPublicKey) keyFactory.generatePublic(keySpec);
  }
}
