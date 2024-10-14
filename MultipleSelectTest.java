import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.*;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleSelectTest {

    Question question1;
    Question question2;
    Question likert;
    Question trueFalse;
    Question multipleChoice;

    @BeforeEach
    void setUp() {
        question1 = new MultipleSelect("What are the two most populous countries in the world?","1 2", "India",
                "China","USA","Russia");
        question2 = new MultipleSelect("Who are the 3 richest people in the world?","1 4 6",
                "Bernard Arnault & family", "Larry Ellison","Mukesh Ambani","Elon Musk",
                "Carlos Slim Helu & family", "Jeff Bezos");
        likert = new Likert("I like movies");
        trueFalse = new TrueFalse("Obama was the 45th POTUS","False");
        multipleChoice = new MultipleChoice("What is the capital of USA?", "Washington D.C.",
                "San Jose","San Diego","Washington D.C.");
    }

    @Test
    void testAnswer() {
        assertEquals("Correct", question1.answer("1 2"));
        assertEquals("Correct", question1.answer("2 1"));
        assertEquals("Correct", question2.answer("1 4 6"));
        assertEquals("Correct", question2.answer("4 1 6"));
        assertEquals("Incorrect", question2.answer("2 5"));
        assertEquals("Incorrect", question2.answer("5 2"));

    }

    @Test
    void testGetText() {
        assertEquals("What are the two most populous countries in the world?", question1.getText());
        assertEquals("Who are the 3 richest people in the world?", question2.getText());

    }

    @Test
    void testCompareTo() {
        assertEquals( 0, question1.compareTo(question1));
        assertEquals( -1, question1.compareTo(question2));
        assertEquals( 1, question2.compareTo(question1));
        assertEquals( -1, question1.compareTo(likert));
        assertEquals( 1, question1.compareTo(trueFalse));
        assertEquals( 1, question1.compareTo(multipleChoice));
    }
}