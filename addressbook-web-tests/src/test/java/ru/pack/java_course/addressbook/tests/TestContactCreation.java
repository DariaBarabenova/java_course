package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContaclList();
    ContactData contact = new ContactData(0,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1");
    app.getContactHelper().createContact(contact);
    app.goToHomePage();
    List<ContactData> after = app.getContactHelper().getContaclList();
    Assert.assertEquals(after.size(),before.size() + 1);
    app.logOut();


    int max = 0;
    for (ContactData c : after) {
      if (c.getId()> max) {
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object> (before), new HashSet<Object> (after));
  }


}
