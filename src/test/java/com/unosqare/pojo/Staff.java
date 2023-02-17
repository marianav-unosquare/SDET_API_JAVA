package com.unosqare.pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonObject;

public class Staff {

	private String name;
	private String age;
	private List<String> skills;
	private List<String> position;
	private Map<String, BigDecimal> salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getPosition() {
		return position;
	}
	public void setPosition(List<String> position) {
		this.position = position;
	}
	public Map<String, BigDecimal> getSalary() {
		return salary;
	}
	public void setSalary(Map<String, BigDecimal> salary) {
		this.salary = salary;
	}

	public String toJson() {
		final StringWriter writable = new StringWriter();
		try {
			this.toJson(writable);
		} catch (final IOException e) {
			System.out.println(e.getMessage());
		}
		return writable.toString();
	}

	public void toJson(Writer writable) throws IOException {
		final JsonObject json = new JsonObject();
		json.put("name", this.getName());
		json.put("age", this.getAge());
		json.put("skills", this.getSkills());
		json.put("position", this.getPosition());
		json.put("salary", this.getSalary());
		json.toJson(writable);
	}
	
}
