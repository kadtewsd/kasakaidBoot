package com.kasakaid.kasakaidBoot;

import com.kasakaid.kasakaidBoot.domain.TestTable;
import com.kasakaid.kasakaidBoot.service.NamedEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KasakaidBootApplication.class})
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data.sql")
})
public class KasakaidBootApplicationTest {

    @Autowired
    private Configuration config;

    @Autowired
    private NamedEntityService service;
    @Test
    public void test1() {
/*        SELECT testtable0_.userId From TestTable testtable0_
        left outer join TestChildTable children1_ on testtable0_.userId=children1_.userId; */
        List<TestTable> test = service.findAll();
        assertThat(test.size(), is(greaterThan(0)));
        assertThat(test.size(), is(equalTo(6)));
    }

    @Test
    public void test2() {
        List<TestTable> test = service.findOne(1);
        assertThat(test.size(), is(equalTo(1)));
    }

}