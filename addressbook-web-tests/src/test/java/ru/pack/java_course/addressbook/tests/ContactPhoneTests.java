package ru.pack.java_course.addressbook.tests;

import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @Test
  public void TestContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom = app.contact().InfoFromEditFrom(contact);
  }

}