# Setup
**1. Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.**
Done. Note that Selenium Logger is probably moved to another dependency. Had to add this to the pom.xml:

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-api</artifactId>
        <version>3.141.59</version>
    </dependency>

# Using an XPath locator
**2. For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?**
(`app_package_name + "addContactButton"` for id locators)

I tried to use classname and xpath locators:
`android.widget.Button` for SimplestClassnameTest
`//android.widget.CheckBox[@content-desc="Show Invisible Contacts (Only)"]` for SimplestXPathTest

You can use Classname and XPath locators to search UI elements without knowing their previously-defined ID (what if your elements are made in runtime?).
XPath locators are longer to write, but allow us searching by different attributes, for example text fields.

# Running on a real device
**3. Modify existing tests to run on a real device. What should be changed?**
Change the "deviceName" capability to an ID of your device. For Android, you can find the id using the `adb devices -l` command.
`capabilities.setCapability("deviceName", "417fce8f7d64");`

# Connect to Appium
**4. Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?**
Real device tests run *way* faster, but need some setup.

First, enable USB Debugging options in the Developer section on your phone.
Make sure you have the following folders in your AndroidSDK installation:
* tools
* platform-tools
* build-tools (platform-tools v18 and higher)
and you have USB drivers. Check if your device is seen using `adb devices -l`.
Don't forget to start the Appium server, of course.

# Refactoring
**5. What should be improved/changed in existing test code? Why, for what?**
(some of them were fixed right away)
* We use Java, so we should use CamelCase in method and variable names!
* There were too many obvious comments in DriverSetup
* Also, we used a specific device in capabilities. Apparently we'll need to use other devices for tests using .json structures.
* There were System.out.println() usages. Better using logging libraries for that.
* A *lot* of hardcoded strings. Better use properties or enums for that. Apparently we'll have to use the pageObject pattern to avoid that as well.
* Moreover, there was an absolute path to the apk in the code. What if we use another environment?
* Better move DriverSetup to main/java? It's not testing anything.
