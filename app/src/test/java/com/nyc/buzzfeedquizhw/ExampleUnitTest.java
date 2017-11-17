package com.nyc.buzzfeedquizhw;

import com.nyc.buzzfeedquizhw.controller.DaoAdapter;
import com.nyc.buzzfeedquizhw.model.DaoModel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    //testing to see that as long

    @Test
    public void testConstructors() {
        String[] nothing = new String[1];
        List<DaoModel> daoModels = new ArrayList<>();
        DaoModel daoModel = new DaoModel("URL", "Question", nothing);
        assertNotNull(daoModel.getAnswer());
        assertNotNull(daoModel.getQuestion());
        assertNotNull(daoModel.getUrl());

        daoModels.add(daoModel);
        DaoAdapter daoAdapter = new DaoAdapter(daoModels);

        assertNotNull(daoAdapter.getChecked(0));
    }
}