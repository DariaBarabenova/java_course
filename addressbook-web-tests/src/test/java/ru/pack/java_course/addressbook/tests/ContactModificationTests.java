package ru.pack.java_course.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;
import ru.pack.java_course.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

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
  public void testContactModification () throws InterruptedException {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    Date date =new Date();
    String datetime = String.valueOf(date.getTime());
    System.out.println(datetime);
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company2")
            .withNcHomeTelephone(datetime).withNcEmail("testemail@test.com").withGroup("test1");
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    Thread.sleep(2000);
    String allPhones = app.wd.findElements(By.cssSelector("tr[name='entry']")).get(0).findElement(By.xpath(".//td[6]")).getText();
    Assert.assertTrue(allPhones.contains(datetime),"Contains no datetime");
  }

}
