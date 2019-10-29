 package com.revature.gradingappsubjectms.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import lombok.Data;

	@Data
	@Entity
	@Table(name = "subject")
	public class Subject {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;
		
		@Column(name = "subcode")
		private String subcode;
		
		@Column(name = "name")
		private String name;
}
