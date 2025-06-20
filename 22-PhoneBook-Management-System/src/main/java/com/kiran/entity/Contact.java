package com.kiran.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String phoneNumber;

	private String email;

}
