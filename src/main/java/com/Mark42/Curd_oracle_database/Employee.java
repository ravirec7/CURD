package com.Mark42.Curd_oracle_database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double salery;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, double salery) {
		super();
		this.name = name;
		this.salery = salery;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalery() {
		return salery;
	}
	public void setSalery(double salery) {
		this.salery = salery;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salery=" + salery + "]";
	}

}
