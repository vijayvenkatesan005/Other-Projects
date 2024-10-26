package questions;

/**
 * Vijay Venkatesan
 * This class represents Likert type questions
 */
public class Likert implements Question{

    String text;

    public Likert(String text){
        this.text = text;

    }

    public String getText(){
        return text;
    }

    public String answer(String answer){
        if ("1".equals(answer) || "2".equals(answer) || "3".equals(answer)
                || "4".equals(answer) || "5".equals(answer)) {
            return "Correct";
        }
        else{
            return "Incorrect";
        }

    }

    public int compareTo(Question o){
        if(o instanceof Likert){
            Likert other = (Likert) o;
            return (int)java.lang.Math.signum(this.getText().compareTo(other.getText()));
        }

        return 1;
    }

}
