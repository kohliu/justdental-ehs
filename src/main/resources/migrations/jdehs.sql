--liquibase formatted sql

--changeset techstomach:1

#----------------------------------------------------------------------------------------------------------
#--------------------------------------------------Tables--------------------------------------------------
#----------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS jd_role;

CREATE TABLE jd_role
(
	roleId BIGINT NOT NULL AUTO_INCREMENT,
	roleName varchar(60),
	roleDescription varchar(255),
	isActive INT NOT NULL DEFAULT 1,
	PRIMARY KEY (roleId)
);


DROP TABLE IF EXISTS jd_user;

-- [NOTE] need to model this differently, user table should have only mandatory fields
-- we shoudl create a userAttribute table which can have 1 to many relationship table with
-- user table and will have only 3-4 coulmns like userAttribute, value, dateCreated, lastUpdated

CREATE TABLE jd_user
(
	userId BIGINT NOT NULL AUTO_INCREMENT,
	roleId_fk BIGINT NOT NULL,
	userType varchar(255) NULL,
	firstName  varchar(255) NULL,
	middleName varchar(255) NULL,
	lastName   varchar(255) NULL,
	emailAddress varchar(255) NULL,
	qualification varchar(255) NULL,
	specialization varchar(255) NULL,
	licenseNumber varchar(255) NULL,
	phoneNumber varchar(255) NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	isActive INT NOT NULL,
	PRIMARY KEY (userId),
	FOREIGN KEY (roleId_fk) REFERENCES jd_role(roleId)
);

DROP TABLE IF EXISTS jd_sso_login;

CREATE TABLE jd_sso_login
(
	ssoLoginId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT NOT NULL,
	providerUniqueId varchar(255) NULL,
	tokenId varchar(255) NULL,
	tokenExpiryDate datetime NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (ssoLoginId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_native_login;

CREATE TABLE jd_native_login
(
	loginId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT NOT NULL,
    uniqueLoginName varchar(255) NOT NULL,
	passwordKey   varchar(255) NOT NULL,
	PasswordQuestion varchar(255) NOT NULL,
	passwordAnswer varchar(255) NULL,
	lastPasswordChanged datetime NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (loginId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_login_tracking;

CREATE TABLE jd_login_tracking
(
	loginTrackId  BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk  BIGINT NOT NULL,
	lastLogin datetime NULL,
	appID INT NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (loginTrackId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_clinic;

CREATE TABLE jd_clinic
(
	clinicId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicName varchar(500) NOT NULL,
	street1 varchar(1000) NOT NULL,
	street2 varchar(1000) NOT NULL,
	locality varchar(500) NOT NULL,
	city varchar(255) NOT NULL,
	state varchar(255)NOT NULL,
	country varchar(255) NOT NULL,
	pincode BIGINT NOT NULL,
	taxNumber varchar(255) NOT NULL,
	primaryContactName varchar(255) NOT NULL,
	primaryContactNumber BIGINT NOT NULL,
	isActive INT NOT NULL,
	gMap varchar(1000) NOT NULL,
	daysAvailable varchar(255) NULL,
	workingHours varchar(255) NULL,
	notification varchar(255) NULL,
	clinicType Varchar(255) NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (clinicId)
);

DROP TABLE IF EXISTS jd_clinic_role_map;

CREATE TABLE jd_clinic_role_map
(
	clinicRoleId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicId_fk BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
	isactive INT NOT NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (clinicRoleId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_booking_slots;

CREATE TABLE jd_booking_slots
(
	slotId  BIGINT NOT NULL AUTO_INCREMENT,
	clinicId_fk BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
	slotDuration Int NOT NULL,
	slotStartTime datetime NOT NULL,
	slotEndTime datetime NOT NULL,
	dateCreated datetime NOT NULL,
	dateModified datetime NOT NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (slotId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_patient;

CREATE TABLE jd_patient
(
	userId_fk BIGINT NOT NULL,
	packageId_fk BIGINT NOT NULL,
	patientDisplayId Varchar(255) NOT NULL,
	firstName varchar(255) NOT NULL ,
	middleName varchar(255) NULL,
	lastName varchar(255) NOT NULL,
	gender varchar(100) NOT NULL,
	dateOfBirth datetime NOT NULL,
	placeOfBirth varchar(255) NOT NULL,
	phoneNumber varchar(255) NOT NULL,
	maritalStatus varchar(100) NOT NULL,
	bloodGroup varchar(100) NOT NULL,
	religion varchar(100) NOT NULL,
	occupation varchar(255) NULL,
	education varchar(255) NULL,
	insuranceNumber varchar(255) NULL,
	insuranceExpiration datetime NULL,
	emergencyContactName varchar(255) NULL,
	emergencyContactRelationship varchar(255) NULL,
	emergencyContactNumber varchar(255) NULL,
	aadharNumber Varchar(255) NULL,
	emailAddress varchar(255) NULL,
	street1 varchar(1000) NULL,
	street2 varchar(1000) NULL,
	lcality varchar(500) NULL,
	city varchar(255) NOT NULL,
	state varchar(255)NOT NULL,
	country varchar(255) NOT NULL,
	pincode BIGINT NOT NULL,
	habbits TEXT NULL,
	medicalHistory LONGTEXT NULL,
	familyHistory LONGTEXT NULL,
	socialHistory LONGTEXT NULL,
	patientNote LONGTEXT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (userId_fk),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_appointment;

CREATE TABLE jd_appointment
(
	appointmentId BIGINT NOT NULL AUTO_INCREMENT,
	clinicId_fk  BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
	appointmentTakenBy varchar(255) NULL,
	appointmentDescription varchar(255) NULL,
    slotDuration INT NOT NULL,
	slotStartTime datetime NOT NULL,
	slotEndTime datetime NOT NULL,
	appoitmentStartTime  datetime NOT NULL,
	appointmentStatus INT NOT NULL,
	userCheckIn datetime NOT NULL,
    userCheckOut datetime NOT NULL,
    invoiceId_fk BIGINT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (appointmentId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId)
);

DROP TABLE IF EXISTS jd_patient_medical_chart;

CREATE TABLE jd_patient_medical_chart
(
	userId_fk BIGINT NOT NULL,
    #category can be general or oral screening  or chief complaint
    chartCategory VARCHAR(255) NOT NULL,
	chartItem Varchar(255) NOT NULL,
	isValid INT NOT NULL DEFAULT 0,
	comments LONGTEXT NULL,
	CreationDate datetime NULL,
	ModifiedDate datetime NULL,
	ModifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

# -- DID NOT UNDERSTAND THIS TABLE --
#CREATE TABLE JD_Chief_Compliant
#(
#Patient_ID int NOT NULL,
#Description Varchar(255) NULL,
#Valid_from datetime NULL,
#Valid_to datetime NULL,
#CreationDate datetime NULL,
#ModifiedDate datetime NULL,
#ModifiedBy varchar(255) NOT NULL
#);

#This can be clubbed with medical chart
#DROP TABLE IF EXISTS jd_patient_oral_screening;

#CREATE TABLE jd_patient_oral_screening
#(
#Patient_ID INT NOT NULL,
#ProblemID_Array Varchar(255) NULL,
#Description Varchar(255) NULL,
#Valid_from datetime NULL,
#Valid_to datetime NULL,
#CreationDate datetime NULL,
#ModifiedDate datetime NULL,
#ModifiedBy varchar(255) NOT NULL
#);

DROP TABLE IF EXISTS jd_diagnostic_chart;

CREATE TABLE jd_diagnostic_chart
(
	procedureId BIGINT NOT NULL AUTO_INCREMENT,
	appointmentId_fk BIGINT NOT NULL,
	clinicId_fk  BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
    # Diagnosis or procedure
    interactionType VARCHAR(255) NOT NULL,
    comments LONGTEXT NULL,
	validFrom datetime NULL,
	validTo datetime NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	ModifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (procedureId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
   	FOREIGN KEY (appointmentId_fk) REFERENCES jd_appointment(appointmentId)

);

DROP TABLE IF EXISTS jd_treatment_plan;

CREATE TABLE jd_treatment_plan
(
	tratmentId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT NOT NULL,
	appointmentId_fk BIGINT NULL,
	clinicId_fk  BIGINT NULL,
	treatmentArray LONGTEXT NULL,
	description LONGTEXT NULL,
	validFrom datetime NULL,
	validTo datetime NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (tratmentId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)

);

DROP TABLE IF EXISTS jd_patient_medication;

CREATE TABLE jd_patient_medication
(
	patientMedicationId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicId_fk  BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
	appointmentId_fk BIGINT NULL,
	procedureId BIGINT NULL,
	instructions varchar(255) NOT NULL,
	startDate datetime NOT NULL,
	endDate datetime NOT NULL,
	CreationDate datetime NULL,
	ModifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (patientMedicationId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId)
);

DROP TABLE IF EXISTS jd_services;

CREATE TABLE jd_services
(
	serviceId BIGINT NOT NULL AUTO_INCREMENT,
	serviceCode VARCHAR(255) NOT NULL,
	serviceName varchar(255) NOT NULL,
	serviceDescription varchar(1000) NOT NULL,
	cost float(14,2) NOT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (serviceId)
);

DROP TABLE IF EXISTS jd_clinic_service_map;

CREATE TABLE jd_clinic_service_map
(
	clinicId_fk BIGINT NOT NULL,
	serviceId_fk BIGINT NOT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (serviceId_fk) REFERENCES jd_services(serviceId)
);

DROP TABLE IF EXISTS jd_clinic_service_cost;

CREATE TABLE jd_clinic_service_cost
(
	clinicId_fk BIGINT NOT NULL,
	serviceId_fk BIGINT NOT NULL,
    cost Float (14,2) NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (serviceId_fk) REFERENCES jd_services(serviceId)
);

DROP TABLE IF EXISTS jd_corporate_package;

CREATE TABLE jd_corporate_package
(
	packageId BIGINT NOT NULL AUTO_INCREMENT,
	packageName varchar(255) NOT NULL,
	serviceId_fk BIGINT NULL,
	serviceDiscount Float (14,2) NULL,
	comments Varchar(500) NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (packageId )
);

DROP TABLE IF EXISTS jd_corporate_package_clinic_service_map;

CREATE TABLE jd_corporate_package_clinic_service_map
(
    packageId_fk BIGINT NOT NULL,
	clinicId_fk BIGINT NOT NULL,
	serviceId_fk BIGINT NOT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (serviceId_fk) REFERENCES jd_services(serviceId),
	FOREIGN KEY (packageId_fk) REFERENCES jd_corporate_package(packageId)
);

DROP TABLE IF EXISTS jd_invoice;

CREATE TABLE jd_invoice
(
	invoiceId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicId_fk BIGINT NOT NULL,
	userId_fk BIGINT NOT NULL,
	appointmentId_fk BIGINT NOT NULL,
	invoiceAmount float(14,2) NOT NULL,
	paymentDateTime datetime NOT NULL,
	description varchar(255) NOT NULL,
	paymentType varchar(255) NOT NULL,
	paymentStatus varchar(255) NOT NULL,
	taxAmount varchar(255) NOT NULL,
	totalAmount float(14,2) NOT NULL,
	creationDate datetime NULL,
	modifiedDate datetime NULL,
	modifiedBy varchar(255) NOT NULL DEFAULT 'adm_jd',
	PRIMARY KEY (invoiceId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (appointmentId_fk) REFERENCES jd_appointment(appointmentId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);