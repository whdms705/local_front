package com.example.front.dashboard.service;


import org.assertj.core.api.ThrowableAssert;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.*;

class Version implements Comparable<Version>{
    Version(String version){
        if(version == null){
            throw new IllegalArgumentException("'version' must not be null!");
        }
    }

    @Override
    public int compareTo(Version o) {
        return 0;
    }

    boolean isSnaphot() {
        return true;
    }
}

public class VersionTest {
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
    public void version_null_check() {
        try {
            Version version = new Version(null);
        } catch (IllegalArgumentException e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorVersionMustNotBeNull);
        }

    }

    @Test
    public void version_format_unmatch() {
        // then
        //expectedExcetption.expect(IllegalArgumentException.class);
        //expectedExcetption.expectMessage(errorVersionMustMatchPattern);


        try {
            // gien
            String versionStr = "3-SNAPSHOT";

            // when
            Version version = new Version(versionStr);
        } catch (IllegalArgumentException e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorVersionMustMatchPattern);
        }
    }

    @Test
    public void version_SNAPSHOT이_소문자인경우() {
        // then
        expectedExcetption.expect(IllegalArgumentException.class);
        expectedExcetption.expectMessage(errorVersionMustMatchPattern);

        // gien
        String versionStr = "3.8.0-snapshot";

        // when
        Version version = new Version(versionStr);
    }

    @Test
    public void version_isSnaphot_ture인경우() {
        // gien
        String versionStr = "3.8.0-SNAPSHOT";

        // when
        Version version = new Version(versionStr);

        // then
        assertThat(version.isSnaphot()).isFalse();
    }

    // expected error messages:

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
}
