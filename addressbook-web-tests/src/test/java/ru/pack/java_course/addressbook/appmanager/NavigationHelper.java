package ru.pack.java_course.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }

  public void closeAlertWindow() {
    wd.switchTo().alert().accept();
  }
}
