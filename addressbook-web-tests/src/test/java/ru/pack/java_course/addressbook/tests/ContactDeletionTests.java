package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion (){
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"), true);
    }
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().closeAlertWindow();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);
  }
}
