package example.courseWorkTwo.services.examiners;

import example.courseWorkTwo.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
