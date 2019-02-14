package org.springframework.samples.petclinic.account;

	import java.util.Date;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

	import org.springframework.format.annotation.DateTimeFormat;
	import org.springframework.samples.petclinic.model.BaseEntity;
	import org.springframework.samples.petclinic.owner.Owner;

	@Entity
	@Table(name="accounts")
	public class Account extends BaseEntity{

		@Column(name="password", unique=true)
		private String password;
		
		@Column(name="username", unique=true)
		private String username;
		
		@Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
		private Date dateOfCreation;

		@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
		private Owner owner;
		
		public Account() {}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Date getDateOfCreation() {
			return dateOfCreation;
		}

		public void setDateOfCreation(Date dateOfCreation) {
			this.dateOfCreation = dateOfCreation;
		}

		public Owner getOwner() {
			return owner;
		}

		public void setOwner(Owner owner) {
			this.owner = owner;
		}
		
}
