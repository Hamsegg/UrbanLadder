//package com.urban.testfile;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.urban.base.BaseClass;
//import com.urban.pageObject.Login;
//
//public class TestMain extends BaseClass {
//	public Login login;
//	@Test
//	public void testInvalidLogin() {
//		String email = "tohordai@gmail.com";
//		String password = "Tohodai@123";
//		String expectedUrl = "https://www.urbanladder.com/login";
//		login = new Login(driver);
//		login.login(email, password);
//		boolean loginFailed = login.isLoginFailed(expectedUrl);
//
//		Assert.assertTrue(loginFailed, "Login should fail with invalid credentials.");
//	}
//
//}
