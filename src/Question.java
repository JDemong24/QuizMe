public class Question {
    private String prompt;
    private String answer;

    public Question(String prompt, String answer){
        this.prompt = prompt;
        this.answer = answer;
    }

    public boolean checkAnswer(String answer){
        if(this.answer.equalsIgnoreCase(answer)){
            return true;
        }else{
            return false;
        }
    }

    public String getAnswer(){
        return answer;
    }

    public String getPrompt(){
        return prompt;
    }

    public String toString(){
        return "The answer to '" + prompt + "' is '" + answer + "'";
    }
}
