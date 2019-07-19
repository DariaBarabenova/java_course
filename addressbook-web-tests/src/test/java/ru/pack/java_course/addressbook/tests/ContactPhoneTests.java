package ru.pack.java_course.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withId(0).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
              .withNcHomeTelephone("1111111").withNcMobilePhone("2222222").withNcWorkPhone("3333333")
              .withNcEmail("testemail@test.com").withGroup("test1"));
    }
  }

  @Test
  public void TestContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

    assertThat(contact.getNcHomeTelephone(), equalTo(contactInfoFromEditForm.getNcHomeTelephone()));
    assertThat(contact.getNcWorkPhone(), equalTo(contactInfoFromEditForm.getNcWorkPhone()));
    assertThat(contact.getNcMobilePhone(), equalTo(contactInfoFromEditForm.getNcMobilePhone()));
  }

}