package ru.pack.java_course.addressbook.model;

public class ContactData {
  private final String ncName;
  private final String ncLastname;
  private final String ncTitle;
  private final String ncCompany;
  private final String ncHomeTelephone;
  private final String ncEmail;

  public ContactData(String ncName, String ncLastname, String ncTitle, String ncCompany, String ncHomeTelephone, String ncEmail) {
    this.ncName = ncName;
    this.ncLastname = ncLastname;
    this.ncTitle = ncTitle;
    this.ncCompany = ncCompany;
    this.ncHomeTelephone = ncHomeTelephone;
    this.ncEmail = ncEmail;
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
}
