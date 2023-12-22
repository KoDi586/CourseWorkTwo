package example.courseWorkTwo;

import example.courseWorkTwo.services.questions.JavaQuestionService;
import example.courseWorkTwo.services.questions.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionServiceTest {
    @Test
    public void add() {
        QuestionService questionService = new JavaQuestionService();
        Assertions.assertEquals(questionService.add("question", "answer"),
                new Question("question", "answer"));
        questionService.add("question1", "answer1");
    }

    @Test
    public void remove() {
        QuestionService questionService = new JavaQuestionService();

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question1", "answer1");
        questionService.add(question1);
        questionService.add(question2);

        Assertions.assertEquals(questionService.remove(question1), question1);
    }

    @Test
    public void getAll() {
        QuestionService questionService = new JavaQuestionService();

        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question1", "answer1");
        questionService.add(question1);
        questionService.add(question2);

        Assertions.assertEquals(2, questionService.getAll().size());

        questionService.remove(question1);
        Assertions.assertEquals(1, questionService.getAll().size());
    }
}
