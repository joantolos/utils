package com.joantolos.utils.utils;

import com.joantolos.utils.StringUtils;
import com.joantolos.utils.exception.StringManipulationException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 *  
 * Created by jtolos on 13/01/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/utils-context-test.xml"})
public class StringUtilsTest {

    @Autowired
    StringUtils stringUtils;
    
    private String test;
    private String[] stringArray;

    @Before
    public void setUp(){
        this.test = "some text with no format what however";

        stringArray = new String[2];
        stringArray[0] = "first element";
        stringArray[1] = "second element";
    }

    @After
    public void tearDown(){
        this.test = null;
    }

    @Test
    public void toCamelCaseTest(){
        String manipulatedString = this.stringUtils.toCamelCase(this.test, " ");
        Assert.assertEquals("someTextWithNoFormatWhatHowever", manipulatedString);
    }

    @Test
    public void toProperCaseTest(){
        String manipulatedString = this.stringUtils.toProperCase(this.test);
        Assert.assertEquals("Some text with no format what however", manipulatedString);
    }

    @Test
    public void firstLetterLowerCaseTest(){
        String manipulatedString = this.stringUtils.firstLetterLowerCase(this.stringUtils.toProperCase(this.test));
        Assert.assertEquals("some text with no format what however", manipulatedString);
    }

    @Test
    public void stringArrayToArrayListTest(){
        ArrayList<String> arrayList = this.stringUtils.stringArrayToArrayList(this.stringArray);
        Assert.assertNotNull(arrayList);
        Assert.assertEquals(arrayList.get(0), "first element");
        Assert.assertEquals(arrayList.get(1), "second element");
    }

    @Test
    public void replaceLastChars() throws StringManipulationException {
        String manipulatedString = this.stringUtils.replaceLastChars(this.test,"whatever",7);
        Assert.assertEquals(manipulatedString, "some text with no format what whatever");
    }
}
