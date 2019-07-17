package ru.pack.java_course.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData(0, "Name", "Lastname", "Title", "Company", "1111111", "testemail@test.com", "test1"));
    }
  }

  @Test
  public void testContactDeletion (){
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().closeAlertWindow();
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size() - 1);


    before.remove(index);
    Assert.assertEquals(before,after);
  }

}
