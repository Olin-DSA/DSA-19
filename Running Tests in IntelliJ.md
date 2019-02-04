# Running Tests in IntelliJ

Note: When loading the code into IntelliJ, instead of creating a new project, Import Project instead and that usually solves a lot of issues.

If you ever have any issues running tests for your code, try some of the steps listed below.

1. Right click the src folder and "Mark directory as" Source Root. 

2. Right click test folder and "Mark directory as" Test Source Root.

3. Create an out folder in day01. In File > Project Structure, under the Project tab in Project Settings, set your Project Compiler Output box to point to your out folder.

4. Make sure your SDK is set up (a warning will appear at the top if it isn't). You should be able to click the warning and choose 11.0.

5. If junit is not being recognized in the test file, you should be able to click the warning that appears (when your cursor is over that area) and add Junit5.3 to the class path. Alternatively, you should be able to Alt-Enter and add Junit5.3 (you might have to put your cursor on the junit in the test file itself).
