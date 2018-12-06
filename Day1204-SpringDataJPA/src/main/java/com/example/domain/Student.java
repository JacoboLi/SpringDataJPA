package com.example.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Component
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "s_name")
	private String sname;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSName() {
		return this.sname;
	}

	public void setSName(String sName) {
		this.sname = sName;
	}

}