package example.courseWorkTwo;

import example.courseWorkTwo.services.examiners.ExaminerService;
import example.courseWorkTwo.services.examiners.ExaminerServiceImpl;
import example.courseWorkTwo.services.questions.JavaQuestionService;
import example.courseWorkTwo.services.questions.QuestionService;
import org.junit.jupiter.api.Test;

public class ExaminerServiceTest {
    @Test
    public void getAmountQuestions() {
        QuestionService questionService = new JavaQuestionService();
        ExaminerService examinerService = new ExaminerServiceImpl(questionService);

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question1", "answer1");
        Question question3 = new Question("question2", "answer2");
        Question question4 = new Question("question3", "answer3");
        Question question5 = new Question("question4", "answer4");
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);
        questionService.add(question4);
        questionService.add(question5);

        System.out.println(examinerService.getQuestions(3));

    }
}
