package com.jikeshijian.week801;

import com.jikeshijian.week801.dao.CustomerInfDao;
import com.jikeshijian.week801.entity.CustomerInf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Week801Application.class)
public class Week801ApplicationTests {

    @Autowired
    private CustomerInfDao customerInfDao;

    @Test
    public void testInsert() {
        CustomerInf customerInf = new CustomerInf();
//        customerInf.setCustomerInfId(1);
        customerInf.setCustomerId(4);
        customerInf.setCustomerName("sai");
        customerInf.setIdentityCardNo(String.valueOf(123456789));
        customerInf.setModifiedTime(new Date().getTime() / 1000);
        customerInfDao.insert(customerInf);
    }

    @Test
    public void testUpdate() {
        CustomerInf customerInf = new CustomerInf();
        customerInf.setCustomerInfId(543640829885939713L);
        customerInf.setCustomerId(23);
        customerInf.setCustomerName("saiWqqqq");
        customerInf.setIdentityCardNo(String.valueOf(123456789));
        customerInf.setModifiedTime(new Date().getTime() / 1000);
        customerInfDao.update(customerInf);
    }

    @Test
    public void testQuery() {
        CustomerInf customerInf = customerInfDao.queryById(543640829885939713L);
        System.out.println("-------------------------"+customerInf.toString());
    }

}
