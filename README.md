# Windows setup guide

1. Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/)

2. Install [Java 8 SDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

3. Download and unpack [Maven 3](http://ftp.ps.pl/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

4. Set [JAVA_HOME](https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/) and [configure Maven](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)

5. Verify installation running `mvn -version` and `java -version`. You should see version number.

# Mac setup guide

1. Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/)

2. Install [Brew](https://brew.sh)

3. Install [Java 8](https://stackoverflow.com/questions/24342886/how-to-install-java-8-on-mac)

4. Install Maven - `brew install maven`

5. Verify installation running `mvn -version` and `java -version`. You should see version number.

# Project setup guide

1. Open IntelliJ and select File -> New -> Project from Version Control -> Git

![Screenshot](setup/1.png)

2. Copy paste [https://github.com/slawekradzyminski/vistulaselenium.git](https://github.com/slawekradzyminski/vistulaselenium.git)

![Screenshot](setup/2.png)

3. After project has loaded open green notification in bottom-right corner. Click on Add as Maven Project

![Screenshot](setup/3.png)

4. Open ArenaTest class and click Setup SDK i top-right corner.

![Screenshot](setup/4.png)

5. Pick Java 8

![Screenshot](setup/5.png)

6. Go to ArenaTest class and run `myFirstSeleniumTest()`. It should work.

# Working with project

There are 9 branches which show solutions to tasks displayed on Slides.

`git checkout part2`

`git checkout part3`

...

`git checkout part9`

Whenever you got stuck you can always discard your changes with

`git reset --hard`

and then checkout desired branch with command showed above.