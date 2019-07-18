package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withId(0).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
            .withNcHomeTelephone("1111111").withNcEmail("testemail@test.com").withGroup("test1");
    app.contact().create(contact);
    app.goToHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size() + 1);


    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
