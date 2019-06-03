package ru.pack.java_course.addressbook.tests;

import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.goToNewContactPage();
    app.fillNewContactForm(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com"));
    app.submitNewContactCreation();
    app.goToHomePage();
    app.logOut();
  }


}
