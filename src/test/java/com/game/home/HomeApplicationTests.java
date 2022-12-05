package com.game.home;

import com.game.home.service.login.util.AuthUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeApplicationTests {

	@Test
	void testEmailRegex() {
		AuthUtil authUtil = new AuthUtil();
		String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,12}$";

//		authUtil.isValidRegex(emailRegex, );
	}

}
