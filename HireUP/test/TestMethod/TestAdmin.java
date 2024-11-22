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
        assertEquals(expectedValue,admin.delete("www.bbc.com"));



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

    @Test
    public void testviewAdminRequest(){
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.viewAdminRequest());
    }

    @Test
    public void testApprove(){
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.approve("nana"));
    }
    @Test
    public void testApprove1() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.approve("oishee"));
    }
    @Test
    public void testReject() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.deleteRequest("ridika"));
    }
    @Test
    public void testApprove2() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.approve("oishee"));
    }
    @Test
    public void testApprove3() {
        boolean expectedValue = true;
        Admin admin = new Admin("ndjd","djigk","djfj","dnhnf");
        assertEquals(expectedValue,admin.approve("Nishat"));
    }
}
