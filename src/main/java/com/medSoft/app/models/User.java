package com.medSoft.app.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Audited
public class User implements UserDetails {

	private static final long serialVersionUID = 7946657849577891456L;
	@Id
	@Column(name = "user_id")
	@GenericGenerator(name = "IntegerIdGenerator", strategy = "com.medSoft.util.IdGenerator")
	@GeneratedValue(generator = "IntegerIdGenerator")
	private int id;
	@Column
	private String username;
	@Column
	private String password;

//	@OneToOne
//	@JoinColumn(name = "companyId", nullable = false)
	@Column
	private String companyId;

	@Column
	private boolean accountNonExpired;

	@Column
	private boolean accountNonLocked;

	@Column
	private boolean credentialsNonExpired;

	@Column
	private boolean enabled;
 
	@Column
	//@OneToOne(mappedBy = "UserRoleId")
	private String role;
	
	@Embedded
	private Base base;

	public User(boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		this.accountNonExpired = true;
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		this.accountNonLocked = true;
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		this.credentialsNonExpired = true;
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		this.enabled = true;
		return this.enabled;
	}

}