**1. Add support of appPackage and appActivity parameters for Android devices (reading from a .properties file and then setting in the DesiredCapabilities). Locally installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.**

Done. See Driver.java

***a. Or try to use autoLaunch capability with app as before. Does this approach work?***

It doesn't with capabilities described in native-android-farm-autolaunch.properties. Let's refer to [the CI section of the Minsk node automation handbook](http://epm-mstfmsq-ci.minsk.epam.com/#!/automation/ci):

> Appium uses "app" Desired Capability to install and launch app from the same host where Appium running. Because your Appium tests and Mobile Cloud are distributed, Desired Capability "app" is ignored at this moment. Appium session for native and hybrid apps should be started with Desired Capability for pre-installed app.

> Therefore, before running Appium test, please install application under test using REST API and then in Desired Capabilities define "bundleId" for iOS and "appActivity" and "appPackage" for Android.

Apparently it only uses the "app" capability to install the AUT, not to actually run it afterwards.

**2. Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?**

The test did pass, see web-ios-farm.properties. [Screenshot from iPhone 5s](https://i.imgur.com/ILAAKAi.png)

**3. Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?**

The test did pass, see native-android-farm.properties. [Screenshot from Nexus 5](https://i.imgur.com/tCyRYKU.jpg)
Although there are two issues:
1. For some reason only Nexus 5 from the Minsk node worked. I couldn't estabilish connection with Samsung phones from mobilecloud.epam.com
2. The app crashes after pressing the Save button because the phone doesn't have any accounts that store contacts (like Google Account, Outlook, messengers...)

**4. What’s wrong with our code? How to fix/improve it? Implement your suggestions.**

There are a lot of things that are actually done, like implementing Page Object pattern and making the build use specific test properties and tests depending on testng.xml loaded.

1. Get rid of System.out.println usages and replace them with some logging, like testNG Reporter.
2. Add some descriptions to the test methods.