package net.viralpatel.contact.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "contact", schema = "public")
public class Contact implements java.io.Serializable {
	private static final long serialVersionUID = 9149826260758390091L;
	private int id;
	private String firstname;
	private String lastname;
	private String cellNo;
	private String emailId;
	private String website;
	private Date birthdate;
	private Date created;

	public Contact() {
	}

	public Contact(int id) {
		this.id = id;
	}

	public Contact(int id, String firstname, String lastname, String cellNo,
			String emailId, String website, Date birthdate, Date created) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cellNo = cellNo;
		this.emailId = emailId;
		this.website = website;
		this.birthdate = birthdate;
		this.created = created;
	}

	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="test_sequence")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "firstname", length = 30)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 30)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "cell_no", length = 15)
	public String getCellNo() {
		return this.cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	@Column(name = "email_id", length = 30)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "website", length = 150)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 13)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
