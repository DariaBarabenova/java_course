package ru.pack.java_course.addressbook.model;

import java.util.Objects;

public class ContactData {

  public ContactData withId(int id) {
    this.id=id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(ncName, that.ncName) &&
            Objects.equals(ncLastname, that.ncLastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ncName, ncLastname);
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

  private int id = Integer.MAX_VALUE;;
  private String ncName;
  private String ncLastname;
  private String ncTitle;
  private String ncCompany;
  private String ncHomeTelephone;
  private String ncEmail;
  private String group;

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", ncName='" + ncName + '\'' +
            ", ncLastname='" + ncLastname + '\'' +
            ", ncTitle='" + ncTitle + '\'' +
            ", ncCompany='" + ncCompany + '\'' +
            ", ncHomeTelephone='" + ncHomeTelephone + '\'' +
            ", ncEmail='" + ncEmail + '\'' +
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

}
