package example.courseWorkTwo;

import example.courseWorkTwo.services.examiners.ExaminerService;
import example.courseWorkTwo.services.examiners.ExaminerServiceImpl;
import example.courseWorkTwo.services.questions.JavaQuestionService;
import example.courseWorkTwo.services.questions.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    JavaQuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    public void initServices() {
        examinerService = new ExaminerServiceImpl(questionService);

    }

    public static void setup(Set<Question> set) {
        set.add(new Question("question11", "answer11"));
        set.add(new Question("question22", "answer22"));
        set.add(new Question("question33", "answer33"));
        set.add(new Question("question44", "answer44"));
        set.add(new Question("question55", "answer55"));
    }

    @Test
    public void getAmountQuestionArray() {
        Set<Question> set = new HashSet<>(List.of());
        setup(set);

        when(questionService.getAll()).thenReturn(set);
        Assertions.assertEquals(3, examinerService.getQuestions(3).size());

        List<Question> list;
        list = new ArrayList<>(examinerService.getQuestions(4));
        Assertions.assertEquals(list.get(0).getClass(), Question.class);

    }

}
