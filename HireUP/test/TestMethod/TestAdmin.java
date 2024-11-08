package TestMethod;

import HireUpMain.Admin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAdmin {
    @Test
    public void testviewInformation() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd" ,"djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.ViewInformation());
    }

    @Test
    public void testDelete() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd" ,"djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.delete("www.dot"));

    }

}
