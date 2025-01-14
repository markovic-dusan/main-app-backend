package com.ftn.e2.isa.blood_simple.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data		// @getter, @setter i @requiredargsconstructor
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "MEDICAL_CENTERS")
public class MedicalCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "center_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "center_address_id", nullable = false, unique = true) // ne mogu 2 centra biti na istoj adresi
	private Address address;
	
	@Column(name = "center_description", nullable = true)
	private String description;
	
	@OneToOne
	@JoinColumn(name = "center_admin_user_id")
	private User admin;
	
	@OneToMany
	private List<User> medicalStaff;
	
	//lista appointmenta
	
}
