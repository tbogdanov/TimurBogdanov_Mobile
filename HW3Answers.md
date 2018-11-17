#HW3 answers
**1. Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?**

Done, see main/java/setup/Driver. Singleton doesn't allow you having multiple instances of the same object or accidentally remaking that instance. For some frameworks like Appium, this is crucial: the driver session will just break if you try to initialize driver with capabilities twice.

**2. Suggest improvements for .properties reading. What are the purposes?**

Test Properties reader should be flexible to several property files. Even if we use specific file names in enums they're as good as hard-coded. Trying to load filenames through testng.xml parameters proved to be a major pain, so it's better to set up the driver during @BeforeSuite in Hooks:
    
    @BeforeSuite(groups = {"native"})
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE_TEST_PROPERTY.toString());
        System.out.println("Driver prepared for NATIVE tests");
    }
    
    @BeforeSuite(groups = {"web"})
    public void setUpWeb() throws Exception {
        prepareDriver(WEB_TEST_PROPERTY.toString());
        System.out.println("Driver prepared for WEB tests");
    }

PrepareDriver should load properties in its body, so no more defining AUT, SUT,... capabilities in its constructor. Leave it for the first usage of PrepareDriver.

The purpose for a separate properties-reading class is to hide all low-level property-reading lines (like System.getProperty(), reading files...) and thus improving code readability and stability.

**3. Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test**

Done, see main/java/pageObjects/AddContactPage and test/hw3/ContactManagerNativeTest

**4. Optional: Add keyboard presence check  in “native” test.**

Failed. People on the Internet suggest two ways of doing that:
1. Assuming that AppiumDriver implements HasOnScreenKeyboard or can be casted to AndroidDriver or iOSDriver. It doesn't and it can't, of course.
2. Checking via driver().hideKeyboard() (when there is no keyboard, it throws an exception). Aside from not making any sense, this method also closes the on-screen keyboard. What if we needed it after checking?

**5. Which checks would you place in the “web” test?**

First we should check if we have elements displayed on the page. Logo, correct texts and links.

**6. Implement checks for “web” test in code and try to use.**

Done, see main/java/pageObjects/IanaSite and test/hw3/IanaWebTest
