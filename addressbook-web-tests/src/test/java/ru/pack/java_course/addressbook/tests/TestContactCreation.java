package ru.pack.java_course.addressbook.tests;

import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().goToNewContactPage();
    app.getContactHelper().fillNewContactForm(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com"));
    app.getContactHelper().submitNewContactCreation();
    app.goToHomePage();
    app.logOut();
  }


}
