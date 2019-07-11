package com.tournity.App.Authentication.Bloc.Controllers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AuthenticationControllerUnitTest {
    @Test
    public void emailValidator_isCorrect() {
        assertTrue(AuthenticationController.validateEmail("Jhonatant@gmail.com"));
        assertFalse(AuthenticationController.validateEmail("Jhonatant"));
    }

    @Test
    public void passwordValidator_isCorrect() {
        assertTrue(AuthenticationController.validatePassword("1234"));
        assertFalse(AuthenticationController.validatePassword(""));
    }
}
