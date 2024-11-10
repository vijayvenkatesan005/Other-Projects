package questions;

import java.util.Arrays;

/**
 * Vijay Venkatesan
 * This class represents multiple select type questions
 */
public class MultipleSelect implements Question{

    String answer;
    String text;
    String[] options;

    public MultipleSelect(String text, String answer, String...options) throws IllegalArgumentException{
        if(options.length < 3 || options.length > 8){
            throw new IllegalArgumentException("Options must be between 3-8 questions inclusive");
        }
        this.text = text;
        this.answer = answer;
        this.options = options;
    }

    public String answer(String answer){

        String[] usersAnswer = answer.split(" ");
        String[] correctAnswer = this.answer.split(" ");

        if(usersAnswer.length != correctAnswer.length){
            return "Incorrect";
        }
        Arrays.sort(usersAnswer);
        Arrays.sort(correctAnswer);

        for(int i = 0; i < usersAnswer.length; i++){
            if(!(usersAnswer[i].equals(correctAnswer[i]))){
                return "Incorrect";
            }
        }

        return "Correct";

    }

    public String getText(){
        return text;
    }

    public int compareTo(Question o){
        if(o instanceof MultipleSelect){
            MultipleSelect other = (MultipleSelect) o;
            return (int)java.lang.Math.signum(this.getText().compareTo(other.getText()));
        }else if(o instanceof Likert){
            return -1;
        }

        return 1;
    }
}
