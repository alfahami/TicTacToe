package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import dev.StringHelper;

@RunWith(Parameterized.class)
public class StringHelperParameterized {

    StringHelper sh = new StringHelper();
    private String input;
    private String expectedOutput;


    public StringHelperParameterized(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs[][] = { {"AACDAA", "CD"}, {"ACD", "CD"} };
       
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncate() {
        assertEquals(expectedOutput, sh.truncateAInFirst2Positions(input));
    }

    @Test
    public void testareFirstAndLastTwoCharactersTheSame() {
        //assertEquals(true, sh.areFirstAndLastTwoCharactersTheSame("AABAA"));
        assertTrue(sh.areFirstAndLastTwoCharactersTheSame(input));
    } {

    }
}
