package com.wq.website;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

	@Value("${spring.datasource.url}")
	private String url;
	@Test
	public void contextLoads() {
		Assert.assertEquals("jdbc:mysql://45.76.205.80:3306/tale",url);
	}

}
