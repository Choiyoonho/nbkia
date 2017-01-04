package org.springex.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * @RunWith, @ContextConfiguration �ֳ����̼��� ���� �׽�Ʈ �ڵ带 ������ �� �������� �ε��ǵ��� �ϴ� �κ�
 * @ContextConfiguration�� locations �Ӽ� ��ο� xml ������ �̿��ؼ� �������� �ε���*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	@Inject
	private DataSource ds;
	//�ν��Ͻ� ������ @Inject �ֳ����̼� ó���� DataSource�� �������� �����ؼ� ������ �ֹǷ� �����ڰ� ��ü ���� Ȥ�� �ٸ� �۾��� ���� �ʾƵ� ��
	
	@Test	//�׽�Ʈ�ؾ��ϴ� ������ �޼ҵ� �ȿ� �ۼ��ϰ� �޼ҵ� ���� @Test �ֳ����̼��� �߰� �ϸ� junit�� �ش� �޼ҵ带 �׽�Ʈ�� �ڵ�� �����ϰ� �׽�Ʈ�� ���� ����.
	public void testConection() throws Exception{
		try(Connection con = ds.getConnection()){	//try(Connection con = ds.getConnection ::) �ڵ� close�� �ڵ� ����ȭ�� ������.
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
