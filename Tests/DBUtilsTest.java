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
        String newUser = "DDuskis";
        String newPass = "Testpass";
        String newEmail = "DDuskis@touro.edu";

        assertEquals("Username Taken", DBUtils.createUser(realuser,realpass,newEmail));
        assertEquals("Added User", DBUtils.createUser(newUser,newPass,newEmail));
        assertEquals("Success", DBUtils.loginUser(newUser,newPass));



    }
}