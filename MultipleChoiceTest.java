import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.*;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleChoiceTest {

    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;

    @BeforeEach
    void setUp() {
        question1 = new MultipleChoice("What is the capital of USA?", "Washington D.C.",
                "San Jose","San Diego","Washington D.C.");
        question2 = new MultipleChoice("What is the most populous state in USA?", "California",
                "Texas", "New York", "California");
        question3 = new MultipleSelect("Which languages are spoken in Singapore?", "1 4 5 6", "Tamil",
                "French", "Spanish", "Malay", "Mandarin Chinese", "English");
        question4 = new Likert("I like movies");
        question5 = new TrueFalse("Obama was the 45th POTUS","False");

    }

    @Test
    void testGetText() {
        assertEquals("What is the capital of USA?", question1.getText());
        assertEquals("What is the most populous state in USA?", question2.getText());
    }

    @Test
    void testAnswer() {
        assertEquals("Correct", question1.answer("Washington D.C."));
        assertEquals("Correct", question2.answer("California"));
        assertEquals("Incorrect", question1.answer("San Jose"));
        assertEquals("Incorrect", question2.answer("Texas"));
    }

    @Test
    void testCompareTo() {
        assertEquals( 0, question1.compareTo(question1));
        assertEquals( -1, question1.compareTo(question2));
        assertEquals( 1, question2.compareTo(question1));
        assertEquals(-1, question1.compareTo(question3));
        assertEquals(-1, question1.compareTo(question4));
        assertEquals(1, question1.compareTo(question5));

    }
}