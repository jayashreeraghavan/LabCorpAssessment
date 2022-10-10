package com.labcorp.restassured.wsdto;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class UsersWsDTO {
    public Object createdAt;
    public String employee_firstname;
    public String employee_lastname;
    public String employee_phonenumbe;
    public String ademployee_emaildress;
    public String citemployee_addressy;
    public String stateemployee_dev_level;
    public String employee_gender;
    public Date employee_hire_date;
    public Object employee_onleave;
    public ArrayList<Object> tech_stack;
    public ArrayList<Object> project;
    public String id;
    public String employee_emaildress;
    public String employee_phonenumber;
}
