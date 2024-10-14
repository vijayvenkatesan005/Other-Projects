package questions;
/**
 * Vijay Venkatesan
 * This class represents True False type questions
 */
public class TrueFalse implements Question{


    String answer;
    String text;

    public TrueFalse(String text, String answer){
        if(!(answer.equals("True") || answer.equals("False"))){
            throw new IllegalArgumentException("The only valid answers are True or False");
        }
        this.answer = answer;
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public String answer(String answer){
         if(answer.equals(this.answer)){
             return "Correct";
         }
         else{
             return "Incorrect";
         }
    }

    public int compareTo(Question o){
        if(o instanceof TrueFalse){
            TrueFalse other = (TrueFalse) o;
            return (int)java.lang.Math.signum(this.getText().compareTo(other.getText()));
        }else if(o instanceof MultipleChoice || o instanceof MultipleSelect || o instanceof Likert){
            return -1;
        }

        return 1;

    }

}
