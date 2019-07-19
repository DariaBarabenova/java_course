package ru.pack.java_course.addressbook.tests;


import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;
import ru.pack.java_course.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestContactCreation extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withId(0).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
            .withNcHomeTelephone("1111111").withNcMobilePhone("2222222").withNcWorkPhone("3333333")
            .withNcEmail("testemail@test.com").withGroup("test1");
    app.contact().create(contact);
    app.goToHomePage();
    assertThat(app.contact().count(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));

  }


}