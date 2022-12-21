package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.y_testSuite;

import org.junit.platform.suite.api.*;

//parent package path
@SelectPackages({"BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework"})

//specific child package path to run @Test
@IncludePackages("BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2")
//@ExcludePackages("")

//@SelectClasses( {
//        c_SeleniumBasicCommands_static_nestedTests.class,
//        c_SeleniumBasicCommands_static_nestedTests.JavaInnerClass.class,
//        c_SeleniumBasicCommands_static_nestedTests.JavaInnerClass.JavaInner_InnerClass.class} )
//@IncludeClassNamePatterns({"^.*Commands?$"})
@IncludeClassNamePatterns({"^.*a_SeleniumBasicCommands?$"})
//@ExcludeClassNamePatterns({"^.e*?$"})


@IncludeTags({"getAttribute"})
//@ExcludeTags("getCssValue")

@Suite
@SuiteDisplayName("A demo Test Suite for BlackBoxTesting")
public class JUnit5TestSuite2
{
//Burasi bos kalabilir
}