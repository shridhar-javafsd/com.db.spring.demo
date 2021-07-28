
package com.db.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MathClassTests {

	/**
	 * 
	 * TDD - test driven development
	 * 
	 */

	@Autowired
	com.db.spring.demo.MathClass mathClass;

	@Test
	public void testAdd() {

		assertEquals(20, mathClass.add(10, 10));
//		assertEquals(20, com.db.spring.demo.MathClass.add(10, 10));

	}

	@Test
	public void testAdd2() {

		assertNotEquals(25, mathClass.add(10, 10));

	}
}
