public class MultipleChoiceQuestion extends Question{
    private String[] choices;
    private static final String[] letters = {"A", "B", "C", "D", "E", "F"};


    public MultipleChoiceQuestion(String prompt, String answer, String[] choices){
        super(prompt, answer);
        this.choices = choices;
        
        System.out.println();
        System.out.println(super.getAnswer());
    }

    

    @Override
    public boolean checkAnswer(String answer){
    
        if (answer.equalsIgnoreCase(choices[0])){
            answer = "A";
        }
        else if (answer.equalsIgnoreCase(choices[1])){
            answer = "B";
        }
        else if (answer.equalsIgnoreCase(choices[2])){
            answer = "C";
        }
        else if (answer.equalsIgnoreCase(choices[3])){
            answer = "D";
        }
        if(super.getAnswer().equalsIgnoreCase(answer)){
            return true;
        }
        return false;
    }
    
    public String getPrompt(){
        String write = super.getPrompt() + " : ";
        for (int i = 0; i < choices.length; i++){
            write = write + "\n" + letters[i] + ". " + choices[i];
        }
        return write;
    }
}
