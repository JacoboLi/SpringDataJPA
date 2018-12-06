package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.Student;
import com.example.domain.StudentRepository;
import com.example.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Day1204SpringDataJpaApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(Day1204SpringDataJpaApplicationTests.class);

	@Inject
	StudentService studentService;
	
	@Inject
	StudentRepository studentRepository;


	@Ignore
	@Test
	public void contextLoads() {
	}

	@PersistenceContext
	EntityManager em;

	/**
	 * 分页操作
	 */
	@Ignore
	@Test
	public void testPage() {
		Map searchParameters = new HashMap();

		Map mapStudent = studentService.getPage();

		System.out.println(mapStudent.get("total"));

		System.out.println(mapStudent.get("students"));
	}
	
	/**
	 * 插入数据
	 */
	@Ignore
	@Test
	public void insert() {
		Student student = new Student();
		student.setSName("ccc");
		studentService.add(student);
	}
	
	/**
	 * 查询数据：
	 * findOne 通过Student表的ID来查询
	 */
	@Ignore
	@Test
	public void select1() {
		final Student student = studentService.findOneById(1);
		System.out.println(student.getSName());
	}
	
	/**
	 * 查询数据
	 * findAll
	 */
	@Ignore
	@Test
	public void select2() {
		final List<Student> findAll = studentService.findAll();
		System.out.println(findAll.size());
	}
	
	/**
	 * 删除
	 */
	@Ignore
	@Test
	public void delete() {
		studentService.deleteId(5);
	}
	
	/**
	 * 修改/更新
	 */
	@Ignore
	@Test
	public void update() {
		studentService.updata(4, "ddd");
	}
	

}
