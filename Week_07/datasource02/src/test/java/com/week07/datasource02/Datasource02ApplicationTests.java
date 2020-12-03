package com.week07.datasource02;

import com.week07.Datasource02Application;
import com.week07.datasource02.dao.CustomerInfDao;
import com.week07.datasource02.entity.CustomerInf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Datasource02Application.class)
public class Datasource02ApplicationTests {

    @Autowired
    private CustomerInfDao customerInfDao;

    @Test
    public void testInsert() {
        CustomerInf customerInf = new CustomerInf();
        customerInf.setCustomerId(1);
        customerInf.setCustomerName("sai");
        customerInf.setIdentityCardNo(String.valueOf(123456789));
        customerInfDao.insert(customerInf);
    }

    @Test
    public void testQuery() {
        CustomerInf customerInf = customerInfDao.queryById(1);
        System.out.println("-------------------------"+customerInf.toString());
    }

}
