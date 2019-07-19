package ru.pack.java_course.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;;
  private String ncName;
  private String ncLastname;
  private String ncTitle;
  private String ncCompany;
  private String ncHomeTelephone;
  private String ncMobilePhone;
  private String ncWorkPhone;
  private String ncEmail;
  private String group;
  private String allPhones;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(ncName, that.ncName) &&
            Objects.equals(ncLastname, that.ncLastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ncName, ncLastname);
  }


  public ContactData withId(int id) {
    this.id=id;
    return this;
  }

  public ContactData withNcName(String ncName) {
    this.ncName = ncName;
    return this;
  }

  public ContactData withNcLastname(String ncLastname) {
    this.ncLastname = ncLastname;
    return this;
  }

  public ContactData withNcTitle(String ncTitle) {
    this.ncTitle = ncTitle;
    return this;
  }

  public ContactData withNcCompany(String ncCompany) {
    this.ncCompany = ncCompany;
    return this;
  }

  public ContactData withNcHomeTelephone(String ncHomeTelephone) {
    this.ncHomeTelephone = ncHomeTelephone;
    return this;
  }

  public ContactData withNcEmail(String ncEmail) {
    this.ncEmail = ncEmail;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withNcMobilePhone(String ncMobilePhone) {
    this.ncMobilePhone = ncMobilePhone;
    return this;
  }

  public ContactData withNcWorkPhone(String ncWorkPhone) {
    this.ncWorkPhone = ncWorkPhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", ncName='" + ncName + '\'' +
            ", ncLastname='" + ncLastname + '\'' +
            ", ncTitle='" + ncTitle + '\'' +
            ", ncCompany='" + ncCompany + '\'' +
            ", ncHomeTelephone='" + ncHomeTelephone + '\'' +
            ", ncMobilePhone='" + ncMobilePhone + '\'' +
            ", ncWorkPhone='" + ncWorkPhone + '\'' +
            ", ncEmail='" + ncEmail + '\'' +
            ", allPhones='" + allPhones + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public String getNcName() {
    return ncName;
  }

  public String getNcLastname() {
    return ncLastname;
  }

  public String getNcTitle() {
    return ncTitle;
  }

  public String getNcCompany() {
    return ncCompany;
  }

  public String getNcHomeTelephone() {
    return ncHomeTelephone;

  }

  public String getNcEmail() {
    return ncEmail;
  }

  public String getGroup() {
    return group;
  }

  public Object getNcWorkPhone() {
    return ncWorkPhone;
  }

  public String getNcMobilePhone() {
    return ncMobilePhone;
  }

}
