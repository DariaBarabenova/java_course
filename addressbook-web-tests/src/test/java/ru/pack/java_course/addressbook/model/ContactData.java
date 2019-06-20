package ru.pack.java_course.addressbook.model;

import java.util.Objects;

public class ContactData {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String ncName;
  private final String ncLastname;
  private final String ncTitle;
  private final String ncCompany;
  private final String ncHomeTelephone;
  private final String ncEmail;
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


  public ContactData(int id, String ncName, String ncLastname, String ncTitle, String ncCompany, String ncHomeTelephone, String ncEmail, String group) {
    this.id = Integer.MAX_VALUE;
    this.ncName = ncName;
    this.ncLastname = ncLastname;
    this.ncTitle = ncTitle;
    this.ncCompany = ncCompany;
    this.ncHomeTelephone = ncHomeTelephone;
    this.ncEmail = ncEmail;
    this.group = group;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(ncName, that.ncName) &&
            Objects.equals(ncLastname, that.ncLastname) &&
            Objects.equals(ncTitle, that.ncTitle) &&
            Objects.equals(ncCompany, that.ncCompany) &&
            Objects.equals(ncHomeTelephone, that.ncHomeTelephone) &&
            Objects.equals(ncEmail, that.ncEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ncName, ncLastname, ncTitle, ncCompany, ncHomeTelephone, ncEmail);
  }
}
