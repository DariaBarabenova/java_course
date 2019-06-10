package ru.pack.java_course.addressbook.tests;

import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"), true);
    }
    app.goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillNewContactForm(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", null), false);
    app.getContactHelper().submitContactModification();
  }
}
