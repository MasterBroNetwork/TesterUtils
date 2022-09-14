# How to compile TesterUtils

(IntelliJ IDEA)
1. Go to Run > Edit Configurations and add a new **Maven** configuration called TesterUtils build.
2. In the configuration, find where it says Run and then type **clean package** (Make sure the working directory is set to TesterUtils)
3. Click Apply and then OK.
4. Next, go to File > Project Structure and go to Artifacts under Project Settings
5. Click the + sign and select JAR > From modules with dependencies and click OK.
6. Click the + sign in your artifact and then click File and select the **plugin.yml** file from the resources directory.
7. Click Apply and then OK.
8. Go to Build > Build Artifacts and click Build.

This will create a new .jar file named after your artifact in a new folder called out under artifacts > YourArtifactName_jar (TesterUtils_jar by default)

If you have successfully followed the steps then you have compiled a new .jar file ready to put in your server's plugins folder and you're done.

**Note**: You will need to go to Build > Build Artifacts and then click Rebuild any time you want to recompile the .jar file after making changes.
