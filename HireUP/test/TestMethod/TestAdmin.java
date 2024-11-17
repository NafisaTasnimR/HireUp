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

    @Test
    public void testVerify() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.verify("www.unilever"));
    }
    @Test
    public void testVerify1() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.verify("www.pran.com"));
    }

}
