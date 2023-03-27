package com.example.api.jwtsecurity.JWTDemoAPi;

import com.example.api.jwtsecurity.JWTDemoAPi.util.JWTTokenUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtDemoAPiApplicationTests {

	@Autowired
    JWTTokenUtil jwtTokenUtil;

	@Test
	void jwtTokenGenerated() {
		String jwt =  jwtTokenUtil.getJWT();
		Assertions.assertNotNull(jwt);
	}
}
