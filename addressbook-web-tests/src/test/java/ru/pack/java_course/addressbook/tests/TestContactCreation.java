package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(0,"Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1");
    app.contact().create(contact);
    app.goToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare (c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
