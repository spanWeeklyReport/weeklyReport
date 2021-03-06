package com.evry.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity()
@Table(name = "USER_DETAILS")
@NamedQueries({
		@NamedQuery(name = "Users.findByUsername", query = "SELECT o FROM UserInfo o WHERE o.userName = :username AND o.password = :password"),
		@NamedQuery(name = "Users.userExists", query = "SELECT o FROM UserInfo o WHERE o.userName = :username") ,
        @NamedQuery(name = "findFirstName", query = "SELECT o FROM UserInfo o WHERE o.firstName = :firstName")}
)
public class UserInfo {
	@Id
	@Column(name = "OID")
	private long oid;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String userRole;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
