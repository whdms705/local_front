package com.example.front.skeleton.service;

import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.regex.Pattern;

import static org.assertj.core.api.Java6Assertions.assertThat;

class Version implements Comparable<Version>{

    String version;

    public Version(String version){
        if(version == null){
            throw new IllegalArgumentException(VersionTest.errorVersionMustNotBeNull);
        }
        String pattern ="\\d+(\\.\\d+){0,2}(-SNAPSHOT)?.";
        boolean regex = Pattern.matches(pattern, version);
        if(regex == false){
            throw new IllegalArgumentException(VersionTest.errorVersionMustMatchPattern);
        }
        this.version = version;
    }

    boolean isSnaphot(){
        return false;
    }

    @Override
    public int compareTo(Version o) {
        if(o == null){
            throw new IllegalArgumentException(VersionTest.errorOtherMustNotBeNull);
        }
        return 0;
    }
}



public class VersionTest {
    public static final String errorVersionMustNotBeNull = "'version' must not be null!";
    public static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    public static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    // ... write your unit tests here ...

    @Rule
    public ExpectedException expectedExcetption = ExpectedException.none();

    @Test(expected = Test.None.class)
    public void exampleTest() {
        Version version = new Version("3.8.0");

        assertThat(version.isSnaphot()).isFalse();
    }

    @Test(expected = Test.None.class)
    public void exampleTest2() {
        Version version = new Version("3.8.0-SNAPSHOT");

        assertThat(version.isSnaphot()).isTrue();
    }

    @Test(expected = Test.None.class)
    public void no_exception_compareTo() {
        Version version = new Version("3.8.0-SNAPSHOT");
        Version version2 = new Version("3.8.1-SNAPSHOT");

        version.compareTo(version2);

        assertThat(version.isSnaphot()).isTrue();
    }

    @Test
    public void version_nullcheck() {
        // then
        expectedExcetption.expect(IllegalArgumentException.class);
        expectedExcetption.expectMessage(errorVersionMustNotBeNull);

        Version version = new Version(null);
    }

    @Test
    public void version_format() {// The test should fail - any suffix allowed
        // then
        expectedExcetption.expect(IllegalArgumentException.class);
        expectedExcetption.expectMessage(errorVersionMustMatchPattern);

        Version version = new Version("3.8.0-SNAP");
    }

    @Test
    public void exception_compareTo(){
        // then
        expectedExcetption.expect(IllegalArgumentException.class);
        expectedExcetption.expectMessage(errorOtherMustNotBeNull);
        Version version = new Version("3.8.0-SNAPSHOT");

        version.compareTo(null);
    }

    // expected error messages:


}
