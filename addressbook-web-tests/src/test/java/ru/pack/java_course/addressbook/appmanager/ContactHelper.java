package ru.pack.java_course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.pack.java_course.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {
    type (By.name("firstname"),contactData.getNcName());
    type (By.name("lastname"),contactData.getNcLastname());
    type (By.name("title"),contactData.getNcTitle());
    type (By.name("company"),contactData.getNcCompany());
    type (By.name("home"),contactData.getNcHomeTelephone());
    type (By.name("email"), contactData.getNcEmail());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void goToNewContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void selectContact(int index) {
    wd.findElements (By.name("selected[]")).get(index).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void editContact() {
    click (By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click (By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact) {
    goToNewContactPage();
    fillNewContactForm(new ContactData()
            .withId(0).withNcName("Name").withNcLastname("Lastname").withNcTitle("Title").withNcCompany("Company")
            .withNcHomeTelephone("1111111").withNcEmail("testemail@test.com").withGroup("test1"), true);
    submitNewContactCreation();
  }

  public void modify(ContactData contact) {
    editContact();
    fillNewContactForm((contact), false);
    submitContactModification();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements){
      String id = element.findElement (By.tagName("input")).getAttribute("value");
      WebElement ncName = element.findElement (By.xpath("//td[3]"));
      WebElement ncLastname = element.findElement (By.xpath("//td[2]"));
      ContactData contact = new ContactData()
              .withId(0).withNcName("Name").withNcLastname("Lastname");
      contacts.add(contact);
    }
    return contacts;
  }
}
