package net.codjo.test.common;
/**
 *
 */
public class JdkUtil {
    public static final boolean JAVA_8 = System.getProperty("java.version").startsWith("1.8.");


    public static String getJdkSuffix() {
        return JAVA_8 ? "-jdk18" : "-jdk15";
    }
}
