# pixy-test
FRC Java code for reading values off a PixyCam as a subsystem. This is a project mainly for my FRC team the EngiNerds, however, if you find it useful, you are free to use it (so long as you keep the credit in the file).

To use, you can copy PixyCam.java in src/main/java/frc/robot/subsystems. A lot of folders, but that's how WPILib projects work. Make sure you have the correct vendordeps installed as well.

This repository abstracts PseudoResonance's Pixy2 Java API to be a subsystem. You can find this at https://github.com/PseudoResonance/Pixy2JavaAPI

To add to your project, you can add the following code to your `build.gradle`:
  * `maven { url 'https://nexus.otake.pw/repository/maven-public/' }` under `repositories`
  * `implementation 'pw.otake.pseudoresonance:pixy2-java-api:1.4.1'` under `dependencies`
