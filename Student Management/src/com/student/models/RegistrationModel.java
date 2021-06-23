package com.student.models;

public class RegistrationModel {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String city;
	private String country;
	private String password;
	// private UploadModel uploadModel;
	private String filePath;
	private String fileName;
	private String Status;

	public RegistrationModel(String firstName, String lastName, String email, String gender, String city,
			String country, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.password = password;
	}

	public RegistrationModel(Integer id, String firstName, String lastName, String email, String gender, String city,
			String country, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.password = password;
	}

	public RegistrationModel(Integer id, String firstName, String lastName, String email, String gender, String city,
			String country, String password, String fileName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.password = password;
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegistrationModel() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "RegistrationModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", city=" + city + ", country=" + country + ", password=" + password
				+ ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}
	
}
