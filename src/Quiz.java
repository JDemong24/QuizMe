
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Quiz {
    public static final String FREE_RESPONSE_QUESTION_TYPE = "FR";
    public static final String MULTIPLE_CHOICE_QUESTION_TYPE = "MC";
    public static final String TRUE_FALSE_QUESTION_TYPE = "TF";
    public static void main(String[] args){
        Quiz quiz = new Quiz("Questions.csv");
        quiz.run();
    }
    Scanner input = new Scanner(System.in);
    ArrayList<Question> questionList = new ArrayList<Question>();
    
    /**
     * Reads the data from a CSV file and prints it to the console.
     * 
     * @param args
     */

    public Quiz(String resourceName){
        try
        {
            InputStream stream =
                Quiz.class.getClassLoader().getResourceAsStream(resourceName);
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(stream));
            
            while (reader.ready())  
            {  
                String line = reader.readLine();
                String[] elements = line.split(",");
            
                String type = elements[0];
                String prompt = elements[1];
                String answer = elements[2];

                if(type.equals(FREE_RESPONSE_QUESTION_TYPE)){
                    Question q1 = new Question(prompt, answer);
                    questionList.add(q1);
                }else if(type.equals(TRUE_FALSE_QUESTION_TYPE)){
                    TrueFalseQuestion q2 = new TrueFalseQuestion(prompt, Boolean.parseBoolean(answer));
                    questionList.add(q2);
                }else{
                    String[] choices = new String[elements.length - 3];
                    for(int i = 3; i < elements.length; i++){
                        choices[i - 3] = elements[i];
                        System.out.println(i-3);
                        System.out.println(elements[i]);
                    }
                    MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(prompt, answer, choices);
                    questionList.add(q3);
                }
            }
            
            reader.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found: " + fnfe.getMessage());
        }
        catch (IOException ioe)
        {
            System.out.println("Error reading line: " + ioe.getMessage());
        }
    }

    public void run(){
        int numCorrect = 0;
        int numQuestions = questionList.size();
        Collections.shuffle(questionList);
        for(Question question : questionList){
            System.out.println(question.getPrompt());
            String answer = input.nextLine();
            if(question.checkAnswer(answer)){
                System.out.println("Correct!");
                numCorrect++;
            }else{
                System.out.println("Incorrect");
            }
        }
        System.out.println(((double) numCorrect / numQuestions) * 100 + "%");
    }
}
