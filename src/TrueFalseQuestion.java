public class TrueFalseQuestion extends Question{

    public TrueFalseQuestion(String prompt, boolean answer){
        super(prompt, String.valueOf(answer));
    }

    @Override
    public boolean checkAnswer(String answer){
        if(answer.equalsIgnoreCase(answer)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getPrompt(){
        return "True or False: " + super.getPrompt();
    }

    @Override
    public String getAnswer(){
        return super.getAnswer();
    }

    @Override
    public String toString(){
        return "'" + super.getPrompt() + "' is " + super.getAnswer();
    }

}

