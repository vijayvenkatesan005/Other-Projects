package questions;

/**
 * Vijay Venkatesan
 * This class represents multiple choice type questions
 */
public class MultipleChoice implements Question{

    String answer;
    String text;
    String [] options;

    public MultipleChoice(String text, String answer, String...options) throws IllegalArgumentException{
        if(options.length < 3 || options.length > 8){
            throw new IllegalArgumentException("Options must be between 3-8 questions inclusive");
        }
        this.text = text;
        this.answer = answer;
        this.options = options;
    }

    public String getText(){
        return text;
    }

    public String answer(String answer){
        if(this.answer.equals(answer)){
            return "Correct";
        }
        else{
            return "Incorrect";
        }
    }

    public int compareTo(Question o){
        if(o instanceof MultipleChoice ){
            MultipleChoice other = (MultipleChoice) o;
            return (int)java.lang.Math.signum(this.getText().compareTo(other.getText()));
        }
        if(o instanceof MultipleSelect || o instanceof Likert ){
            return -1;
        }

        return 1;

    }
}
