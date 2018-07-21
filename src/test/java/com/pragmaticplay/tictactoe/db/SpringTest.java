package com.pragmaticplay.tictactoe.db;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pragmaticplay.tictactoe.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public abstract class SpringTest {
	
}
