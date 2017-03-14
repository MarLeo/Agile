package AllTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.EmployeeTest;
import model.ManagerTest;
import model.PlayerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({PlayerTest.class, ManagerTest.class, EmployeeTest.class})
public class AllTestsSuite {}
