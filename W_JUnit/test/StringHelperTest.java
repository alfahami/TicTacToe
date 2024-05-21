package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.StringHelper;

public class StringHelperTest {

    StringHelper sh;
    
    @Before
    public void before() {
        sh = new StringHelper();
    }

    @Test
    public void testTruncate() {
        assertEquals("CD", sh.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testareFirstAndLastTwoCharactersTheSame() {
        //assertEquals(true, sh.areFirstAndLastTwoCharactersTheSame("AABAA"));
        assertTrue(sh.areFirstAndLastTwoCharactersTheSame("ABAB"));
    } {

    }

}
