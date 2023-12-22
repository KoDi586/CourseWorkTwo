package example.courseWorkTwo.controllers;

import example.courseWorkTwo.Question;
import example.courseWorkTwo.services.questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

//    @Autowired
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/add")
    private Question addQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping
    private Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/remove")
    private Question removeQuestion(@RequestParam String question,
                                    @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
