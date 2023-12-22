package example.courseWorkTwo.services.questions;

import example.courseWorkTwo.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>(List.of());

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);

        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRundomQuestion() {

        // Генерируйте случайное число от 0 до кол-ва всех элементов - 1;
        Random random = new Random();
        int randomNumber = random.nextInt(questions.size());

        // так как set это не упорядоченная структура данных метода get() по индексу
        // у него нет, и одно из решений таково;
        int count = 0;
        for (Question question : questions) {
            if (count == randomNumber) {
                return question;
            }
            count++;
        }
        throw new RuntimeException();
    }
}
