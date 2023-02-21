package com.hermes.spring3;

import com.hermes.spring3.config.MyBeanA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;

import java.util.Optional;

@SpringBootTest
class Spring3ApplicationTests {

	@Autowired
	private Optional<MyBeanA> myBeanA;

	@Autowired
	@Nullable
	private MyBeanA myBeanA1;

	@Test
	void contextLoads() {
		Assertions.assertFalse(myBeanA.isPresent());
		Assertions.assertNull(myBeanA1);
	}

}
