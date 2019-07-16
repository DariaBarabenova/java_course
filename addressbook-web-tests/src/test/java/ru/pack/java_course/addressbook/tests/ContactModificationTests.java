package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(0, "Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"));
    }
  }

  @Test
  public void testContactModification () {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContaclList();
    int index = before.size() - 1;
    ContactData contact = new ContactData (0,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", null);
    app.getContactHelper().modifyContact(contact);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContaclList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare (c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
