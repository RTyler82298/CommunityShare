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
}