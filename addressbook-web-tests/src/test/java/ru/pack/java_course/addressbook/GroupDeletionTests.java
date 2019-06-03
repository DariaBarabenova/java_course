package ru.pack.java_course.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    seleteSelectedGroups();
    returnToGroupPage();
  }


}
