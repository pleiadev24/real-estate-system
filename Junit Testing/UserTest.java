//package syslink;
//
//import org.junit.Assert;
//import org.junit.Test;
//import sysLink.NewUserMenu;
//import user.User;
//
//public class UserTest
//{
//    @Test
//    public void testCreateUser(){
//        String firstName = "Rock";
//        String lastName = "Lee";
//        String email = "aa@gmail.com";
//        String address = "xx road";
//        String password = "rockLee233";
//        String type = "buyer";
//        User user = NewUserMenu.createUser(firstName, lastName, email, address, password, type);
//        Assert.assertNotNull(user);
//        if(null != user){
//            NewUserMenu.user.users.add(user); }
//
//
//        // negative case, user already exists
//        user = NewUserMenu.createUser(firstName, lastName, email, address, password, type);
//        Assert.assertNull(user);
//
//    }
//
//
//
//    @Test
//    public void testCheckParam(){
//        String firstName = "Rock";
//        String lastName = "Lee";
//        String email = "aa@gmail.com";
//        String address = "xx road";
//        String password = "rockLee233";
//        boolean flag = NewUserMenu.checkParam(firstName, lastName, email, address, password);
//        System.out.println(flag);
//        Assert.assertTrue(flag);
//
//
//        // invalid email
//        firstName = "Rock";
//        lastName = "Lee";
//        email = "rock";
//        address = "xx road";
//        password = "rockLee233";
//        flag = NewUserMenu.checkParam(firstName, lastName, email, address, password);
//        System.out.println(flag);
//        Assert.assertTrue(!flag); }
//
//
//
//    @Test
//    public void testCheckEmail(){
//        String email = "aa@gmail.com";
//        boolean flag = NewUserMenu.checkEmail(email);
//        System.out.println(flag);
//        Assert.assertTrue(flag);
//
//
//
//        //negative
//        String negEmail = "aa@gmail";
//        boolean negFlag = NewUserMenu.checkEmail(negEmail);
//        System.out.println(negFlag);
//        Assert.assertTrue(!negFlag); }
//
//
//    @Test
//    public void testGenUserId(){
//        String userId =NewUserMenu.genUserId("vendor");
//        System.out.println(userId);
//        Assert.assertNotNull(userId);
//        Assert.assertEquals("vendor001", userId);
//        String userId1 = NewUserMenu.genUserId("vendor");
//        System.out.println(userId1); Assert.assertNotNull(userId1);
//        Assert.assertEquals("vendor002", userId1);
//
//        //negative
//        String userId2 = NewUserMenu.genUserId("invalidType");
//        System.out.println(userId2);
//        Assert.assertTrue("".equals(userId2));
//}