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
	isActive INT,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (roleId)
);


DROP TABLE IF EXISTS jd_user;

-- [NOTE] need to model this differently, user table should have only mandatory fields
-- we shoudl create a userAttribute table which can have 1 to many relationship table with
-- user table and will have only 3-4 coulmns like userAttribute, value, dateCreated, lastUpdated

CREATE TABLE jd_user
(
	userId BIGINT NOT NULL AUTO_INCREMENT,
-- roleId_fk BIGINT NOT NULL,
	userType varchar(255),
    uniqueUserId varchar(255),
    userPassword varchar(500),
	firstName  varchar(255),
	middleName varchar(255),
	lastName   varchar(255),
	emailAddress varchar(255),
	gender varchar(255),
	qualification varchar(255),
	specialization varchar(255),
	phoneNumber varchar(255),
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	isActive INT,
	PRIMARY KEY (userId)
-- FOREIGN KEY (roleId_fk) REFERENCES jd_role(roleId)
);

DROP TABLE IF EXISTS jd_sso_login;

CREATE TABLE jd_sso_login
(
	ssoLoginId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT,
	providerUniqueId varchar(255),
	tokenId varchar(255),
	tokenExpiryDate datetime,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (ssoLoginId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_native_login;

CREATE TABLE jd_native_login
(
	loginId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT,
    uniqueLoginName varchar(255),
	passwordKey   varchar(255),
	PasswordQuestion varchar(255),
	passwordAnswer varchar(255),
	lastPasswordChanged datetime,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (loginId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_login_tracking;

CREATE TABLE jd_login_tracking
(
	loginTrackId  BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk  BIGINT,
	lastLogin datetime,
	appID INT,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (loginTrackId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_clinic;

CREATE TABLE jd_clinic
(
	clinicId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicName varchar(500),
	street1 varchar(1000),
	street2 varchar(1000),
	locality varchar(500),
	city varchar(255),
	state varchar(255),
	country varchar(255),
	pincode BIGINT,
	taxNumber varchar(255),
	primaryContactName varchar(255),
	primaryContactNumber BIGINT,
	isActive INT,
	gMap varchar(1000),
	daysAvailable varchar(255),
	workingHours varchar(255),
	notification varchar(255),
	clinicType Varchar(255),
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (clinicId)
);

DROP TABLE IF EXISTS jd_clinic_role_map;

CREATE TABLE jd_clinic_role_map
(
	clinicRoleId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicId_fk BIGINT,
	userId_fk BIGINT,
	isActive INT,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (clinicRoleId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_booking_slots;

CREATE TABLE jd_booking_slots
(
	slotId  BIGINT NOT NULL AUTO_INCREMENT,
	clinicId_fk BIGINT,
	userId_fk BIGINT,
	slotDuration Int,
	slotStartTime datetime,
	slotEndTime datetime,
	dateCreated datetime,
	dateModified datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (slotId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_patient;

CREATE TABLE jd_patient
(
    userId BIGINT NOT NULL,
	packageId_fk BIGINT,
	patientDisplayId Varchar(255),
	dateOfBirth datetime ,
	placeOfBirth varchar(255),
	maritalStatus varchar(100),
	bloodGroup varchar(100),
	religion varchar(100),
	occupation varchar(255),
	education varchar(255),
	insuranceNumber varchar(255),
	insuranceExpiration datetime,
	emergencyContactName varchar(255),
	emergencyContactRelationship varchar(255),
	emergencyContactNumber varchar(255),
	aadharNumber Varchar(255),
	street1 varchar(1000),
	street2 varchar(1000),
	locality varchar(500),
	city varchar(255),
	state varchar(255),
	country varchar(255),
	pincode BIGINT,
	habbits TEXT,
	medicalHistory LONGTEXT,
	familyHistory LONGTEXT,
	socialHistory LONGTEXT,
	patientNote LONGTEXT
);

DROP TABLE IF EXISTS jd_appointment;

CREATE TABLE jd_appointment
(
	appointmentId BIGINT NOT NULL AUTO_INCREMENT,
	clinicId_fk  BIGINT,
	userId_fk BIGINT,
	appointmentTakenBy varchar(255),
	appointmentDescription varchar(255),
    slotDuration INT,
	slotStartTime datetime,
	slotEndTime datetime,
	appointmentStartTime  datetime,
	appointmentStatus INT,
    invoiceId_fk BIGINT,
	creationDate datetime,
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
	ModifiedBy varchar(255),
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
	ModifiedBy varchar(255),
	PRIMARY KEY (procedureId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
   	FOREIGN KEY (appointmentId_fk) REFERENCES jd_appointment(appointmentId)

);

DROP TABLE IF EXISTS jd_treatment_plan;

CREATE TABLE jd_treatment_plan
(
	tratmentId BIGINT NOT NULL AUTO_INCREMENT,
	userId_fk BIGINT,
	appointmentId_fk BIGINT,
	clinicId_fk  BIGINT,
	treatmentArray LONGTEXT,
	description LONGTEXT,
	validFrom datetime,
	validTo datetime,
	creationDate datetime,
	modifiedDate datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (tratmentId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)

);

DROP TABLE IF EXISTS jd_patient_medication;

CREATE TABLE jd_patient_medication
(
	patientMedicationId BIGINT NOT NULL AUTO_INCREMENT ,
	clinicId_fk  BIGINT,
	userId_fk BIGINT,
	appointmentId_fk BIGINT,
	procedureId BIGINT,
	instructions varchar(255),
	startDate datetime,
	endDate datetime,
	CreationDate datetime,
	ModifiedDate datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (patientMedicationId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId)
);

DROP TABLE IF EXISTS jd_services;

CREATE TABLE jd_services
(
	serviceId BIGINT NOT NULL AUTO_INCREMENT,
	serviceCode VARCHAR(255),
	serviceName varchar(255),
	serviceDescription varchar(1000),
	cost float(14,2),
	creationDate datetime,
	modifiedDate datetime,
	modifiedBy varchar(255),
	PRIMARY KEY (serviceId)
);

DROP TABLE IF EXISTS jd_clinic_service_map;

CREATE TABLE jd_clinic_service_map
(
	clinicId_fk BIGINT NOT NULL,
	serviceId_fk BIGINT NOT NULL,
	creationDate datetime,
	modifiedDate datetime,
	modifiedBy varchar(255),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (serviceId_fk) REFERENCES jd_services(serviceId)
);

DROP TABLE IF EXISTS jd_clinic_service_cost;

CREATE TABLE jd_clinic_service_cost
(
	clinicId_fk BIGINT NOT NULL,
	serviceId_fk BIGINT NOT NULL,
    cost Float (14,2),
	creationDate datetime,
	modifiedDate datetime,
	modifiedBy varchar(255),
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
	modifiedBy varchar(255),
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
	modifiedBy varchar(255) ,
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
	modifiedBy varchar(255),
	PRIMARY KEY (invoiceId),
	FOREIGN KEY (clinicId_fk) REFERENCES jd_clinic(clinicId),
	FOREIGN KEY (appointmentId_fk) REFERENCES jd_appointment(appointmentId),
	FOREIGN KEY (userId_fk) REFERENCES jd_user(userId)
);

DROP TABLE IF EXISTS jd_subscribe;


CREATE TABLE jd_subscribe
(
	subscriptionId BIGINT NOT NULL AUTO_INCREMENT,
	emailAddress varchar(200),
	PRIMARY KEY (subscriptionId)
);;