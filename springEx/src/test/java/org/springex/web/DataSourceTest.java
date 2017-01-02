package org.springex.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * @RunWith, @ContextConfiguration 애노테이션은 현재 테스트 코드를 실행할 때 스프링이 로딩되도록 하는 부분
 * @ContextConfiguration의 locations 속성 경로에 xml 파일을 이용해서 스프링이 로딩됨*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	@Inject
	private DataSource ds;
	//인스턴스 변수의 @Inject 애노테이션 처리된 DataSource는 스프링이 생성해서 주입해 주므로 개발자가 객체 생성 혹은 다른 작업을 하지 않아도 됨
	
	@Test	//테스트해야하는 내용을 메소드 안에 작성하고 메소드 위에 @Test 애노테이션을 추가 하면 junit은 해당 메소드를 테스트용 코드로 간주하고 테스트를 진행 가능.
	public void testConection() throws Exception{
		try(Connection con = ds.getConnection()){	//try(Connection con = ds.getConnection ::) 자동 close로 코드 간결화를 도와줌.
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
