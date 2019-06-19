package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.List;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContaclList();
    app.getContactHelper().createContact(new ContactData(null,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"), true);
    app.goToHomePage();
    List<ContactData> after = app.getContactHelper().getContaclList();
    Assert.assertEquals(after.size(),before.size() + 1);
    app.logOut();
  }


}
