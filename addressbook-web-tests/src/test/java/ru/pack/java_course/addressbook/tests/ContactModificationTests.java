package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(null, "Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"), true);
    }
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContaclList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    ContactData contact = new ContactData (null,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", null);
    app.getContactHelper().fillNewContactForm((contact), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContaclList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
