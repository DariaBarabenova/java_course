package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData(0, "Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"));
    }
  }

  @Test
  public void testContactModification () {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData (0,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", null);
    app.contact().modify(contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare (c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
