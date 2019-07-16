package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(0, "Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"));
    }
  }

  @Test
  public void testContactDeletion (){
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContaclList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().closeAlertWindow();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContaclList();
    Assert.assertEquals(after.size(),before.size() - 1);


    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }
}
