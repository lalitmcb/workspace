package com.lalit.hibernate.annotation.model;

import javax.persistence.*;

/**
 * Student represents the domain model. This class 
 * definitions will be used to make the object instances.
 * Hibernate will save this object data into database based 
 * on the mapping
 * @author lalit
 *
 */
//Entity annotation represents that it is an entity class and is 
//mapped to a table in database. Table annotation tells about the 
//table name to which this entity is mapped
@Entity
@Table(name="Student")
//@org.hibernate.annotations.Entity(
//	dynamicInsert=true,
//	dynamicUpdate=true)
public class Student {
	
	//Id will correspond the primary key in the database
	private Long id;
	protected String name;
	protected Integer age;
	
	@Column(name="age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//Id - Represents that it is a primary key column
	//GeneratedValue - How the key to be generated
	//column - Column to which this property is mapped
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STUDENT_ID")	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	//There is annotation here so by default it is mapped to 
	//the column with name NAME. In annotation, the properties are 
	//by default mapped. In XML mapping by default the columns
	//are not mapped.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
