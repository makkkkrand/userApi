package com.medSoft.app.models;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Role {
	
	@Id
	@Column(name = "UserRoleId")
	private int UserRoleId;
	@Column
	private String role;
	@Embedded
	private Base base;
	
}
