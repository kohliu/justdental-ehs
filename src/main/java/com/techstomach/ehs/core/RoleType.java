package com.techstomach.ehs.core;

/**
 * Created by ujjwal on 3/5/2017.
 */
public enum RoleType {

    PATIENT(1),
    DOCTOR(2),
    DOCTOR_CLINIC(3),
    DOCTOR_SPECIALIST(4),
    CLINIC_STAFF(5),
    ADMIN(50),
    TECH_SUPPORT(100);

    private long roleId;

    private RoleType(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }
}