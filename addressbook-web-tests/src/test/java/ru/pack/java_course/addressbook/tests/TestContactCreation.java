package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"), true);
    app.goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
    app.logOut();
  }


}
