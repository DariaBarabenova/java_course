package ru.pack.java_course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.pack.java_course.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillNewContactForm(ContactData contactData) {
    type (By.name("firstname"),contactData.getNcName());
    type (By.name("lastname"),contactData.getNcLastname());
    type (By.name("title"),contactData.getNcTitle());
    type (By.name("company"),contactData.getNcCompany());
    type (By.name("home"),contactData.getNcHomeTelephone());
    type (By.name("email"), contactData.getNcEmail());
  }

  public void goToNewContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
