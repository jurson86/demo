package com.abo;

import com.abo.service.impl.Demo ;
import com.abo.service.Impl.Demo3;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	Demo iDemo1;
	@Autowired
	Demo3 demo3;

	@Before
	public void setup(){
		iDemo1.setDemo2(demo3);
	}

	@Test
	public void contextLoads() {
		iDemo1.myTest();
	}

}
