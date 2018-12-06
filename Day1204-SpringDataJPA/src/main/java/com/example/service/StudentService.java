package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Student;
import com.example.domain.StudentRepository;

@Service
public class StudentService {
	
	@Inject
	StudentRepository studentRepository;
	
	
	/**
	 * 分页操作
	 * @return
	 */
	public Map getPage() {
		Map map = new HashMap();
		Page<Student> pageList;
			Specification<Student> spec = new Specification<Student>() {
				public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> pl = new ArrayList<Predicate>();
					// 查询出未删除的
//					pl.add(cb.equal(root.<Integer>get("flag"), 1));
					return cb.and(pl.toArray(new Predicate[0]));
				}
			};
			pageList = studentRepository.findAll(spec, PageRequest(1,3,new Sort(Direction.ASC,"id")));

		map.put("total", pageList.getTotalElements());
		List<Student> list = pageList.getContent();
		 
		map.put("depts", list);
		return map;
	}


	private Pageable PageRequest(int i, int j, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 查询findOne
	 */
	public Student findOneById(Integer id) {
		final Student student = studentRepository.findOne(id);
		return student;
	}
	
	/**
	 * 查询findAll
	 */
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	/**
	 * 删除通过ID
	 */
	public void deleteId(Integer id) {
		studentRepository.delete(id);
	}
	
	/**
	 *插入
	 */
	public void add(Student student) {
		studentRepository.saveAndFlush(student);
	}
	
	/**
	 * 修改/更新
	 */
	public void updata(Integer id , String name) {
		studentRepository.updateName(id,name);
	}
}

