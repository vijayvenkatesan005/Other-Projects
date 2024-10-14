import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import questions.*;

public class LikertTest {

    Question question1;
    Question question2;
    Question trueFalse;
    Question multipleChoice;
    Question multipleSelect;

    @BeforeEach
    public void setUp() {
        question1 = new Likert("I love pizza");
        question2 = new Likert("I like ice cream");
        trueFalse = new TrueFalse("Obama was the 45th POTUS","False");
        multipleChoice = new MultipleChoice("What is the capital of USA?", "Washington D.C.",
                "San Jose","San Diego","Washington D.C.");
        multipleSelect = new MultipleSelect("What are the two most populous countries in the world?","1 2", "India",
                "China","USA","Russia");
    }

    @org.junit.jupiter.api.Test
     void testGetText() {
        assertEquals("I love pizza", question1.getText());
        assertEquals("I like ice cream", question2.getText());

    }

    @org.junit.jupiter.api.Test
     void testAnswer() {
        //normal
        assertEquals("Correct", question1.answer("1"));
        assertEquals("Correct", question2.answer("3"));
        assertEquals("Incorrect", question1.answer("17"));

        //edge
        assertEquals("Correct", question2.answer("5"));



    }

    @org.junit.jupiter.api.Test
     void testCompareTo() {
        assertEquals( 0, question1.compareTo(question1));
        assertEquals( -1, question2.compareTo(question1));
        assertEquals( 1, question1.compareTo(question2));
        assertEquals(1, question1.compareTo(trueFalse));
        assertEquals(1, question1.compareTo(multipleChoice));
        assertEquals(1, question1.compareTo(multipleSelect));

    }
}