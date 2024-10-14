import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrueFalseTest {

    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;


    @BeforeEach
    void setUp() {
        question1 = new TrueFalse("Obama was the 45th POTUS","False");
        question2 = new TrueFalse("Trump was the 45th POTUS","True");
        question3 = new MultipleChoice("How many grams are in one kilogram?", "1000", "1000",
                "500", "250", "750");
        question4 = new MultipleSelect("Which languages are spoken in Singapore?", "1 4 5 6", "Tamil",
                "French", "Spanish", "Malay", "Mandarin Chinese", "English");
        question5 = new Likert("I like movies");

    }

    @Test
    void testGetText() {
        assertEquals("Obama was the 45th POTUS", question1.getText());
        assertEquals("Trump was the 45th POTUS", question2.getText());
    }

    @Test
    void testAnswer() {
        assertEquals("Correct", question1.answer("False"));
        assertEquals("Correct", question2.answer("True"));
        assertEquals("Incorrect", question1.answer("True"));
        assertEquals("Incorrect", question2.answer("False"));
    }

    @Test
    void testCompareTo() {
        assertEquals( 0, question1.compareTo(question1));
        assertEquals( -1, question1.compareTo(question2));
        assertEquals(1, question2.compareTo(question1));
        assertEquals(-1, question1.compareTo(question3));
        assertEquals(-1, question1.compareTo(question4));
        assertEquals(-1, question1.compareTo(question5));
        assertEquals(-1, question2.compareTo(question3));
        assertEquals(-1, question2.compareTo(question4));
        assertEquals(-1, question2.compareTo(question5));
    }

    @Test
    void testIsSorted(){
        Question [] inputQuestionnaire = {question5, question4, question3, question2};
        Question [] sortedQuestionnaire = {question2, question3, question4, question5};
        Arrays.sort(inputQuestionnaire);
        assertTrue(Arrays.equals(sortedQuestionnaire, inputQuestionnaire));
    }


}