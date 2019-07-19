package ru.pack.java_course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.pack.java_course.addressbook.model.ContactData;
import ru.pack.java_course.addressbook.model.Contacts;

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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
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
    contactCache = null;
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editContact();
    fillNewContactForm((contact), false);
    submitContactModification();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("entry")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      WebElement ncName = element.findElement (By.xpath(".//td[3]"));
      WebElement ncLastname = element.findElement (By.xpath(".//td[2]"));

      ContactData contact = new ContactData().withId(id).withNcName("Name").withNcLastname("Lastname");
      contactCache.add(contact);
      String allPhones = element.findElement(By.xpath(".//td[5]")).getText();
      String[] phones = allPhones.split("\n");
      contactCache.add(new ContactData().withId(id).withNcName("Name").withNcLastname("Lastname").withNcHomeTelephone(phones[0])
              .withNcMobilePhone(phones[1]).withNcWorkPhone(phones[2]));
    }
    return new Contacts(contactCache);
  }


  public ContactData InfoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String NcName = wd.findElement(By.name("Name")).getAttribute("value");
    String NcLastname = wd.findElement(By.name("Lastname")).getAttribute("value");
    String NcHomeTelephone = wd.findElement(By.name("HomeTelephone")).getAttribute("value");
    String NcMobilePhone = wd.findElement(By.name("MobilePhone")).getAttribute("value");
    String NcWorkPhone = wd.findElement(By.name("WorkPhone")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withNcName("Name").withNcLastname("Lastname").withNcHomeTelephone("HomeTelephone")
            .withNcMobilePhone("MobilePhone").withNcWorkPhone("WorkPhone");

  }

  private void initContactModificationById(int id) {
    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
  }
}
