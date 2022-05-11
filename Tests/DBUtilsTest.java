import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilsTest {

    @Test
    void getPosterUsername() {
        assertEquals("Rdstyler82298", DBUtils.getPosterUsername(11));
        assertEquals("Rdstyler",DBUtils.getPosterUsername(2));
    }





    @Test
    void getPosterEmailTest() {

        assertEquals("Rtyler@student.touro.edu", DBUtils.getPosterEmail("Rdstyler82298"));
    }

    @Test
    void loginUser() {
        String realuser = "Rdstyler82298";
        String realpass = "MyPassword123";
        String fakeUser = "notarealname";
        String fakepass = "blah";

        assertEquals("Success",DBUtils.loginUser(realuser,realpass));
        assertEquals("Error", DBUtils.loginUser(fakeUser,fakepass));
        assertEquals("Error", DBUtils.loginUser(realuser,fakepass));

    }

    @Test
    void createUser() {
        String realuser = "Rdstyler82298";
        String realpass = "MyPassword123";
        String newUser = "Mcohen";
        String newPass = "MCON364";
        String newEmail = "Mchohen@touro.edu";

        assertEquals("Username Taken", DBUtils.createUser(realuser,realpass,newEmail));



    }
}