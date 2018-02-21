### Backbase QA Test Project

##### Prerequisites
Java 1.8
Maven 3.5 +

##### Configuring test envionment
Configure the test-suite.properties file for the environment.

Supported OS: windows/unix

Supported Browsers: chrome/firefox
```
testing.os=windows
testing.browser=chrome
```

##### Running tests
Run the following command from the top level
````
mvn clean test
````

##### Tested Environments
Windows 10 (Firefox 58.0.2 / Chrome 64.0.3282.167)

Ubuntu 16.04 (Firefox 58.0.2 / Chrome 64.0.3282.167)