import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilsTest {

    @Test
    void getPosterUsername() {
    }

    @Test
    void getPosterEmailTest() {

        assertEquals("Rtyler@student.touro.edu", DBUtils.getPosterEmail("Rdstyler82298"));
    }
}