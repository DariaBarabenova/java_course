package ru.pack.java_course.addressbook;

import org.testng.annotations.Test;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    goToNewContactPage();
    fillNewContactForm(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com"));
    submitNewContactCreation();
    goToHomePage();
    logOut();
  }


}
