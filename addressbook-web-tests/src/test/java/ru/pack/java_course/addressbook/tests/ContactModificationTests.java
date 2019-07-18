package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withId(0).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
              .withNcHomeTelephone("1111111").withNcEmail("testemail@test.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification () {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
            .withNcHomeTelephone("1111111").withNcEmail("testemail@test.com").withGroup("test1");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);
  }

}
