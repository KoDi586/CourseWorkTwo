package example.courseWorkTwo.services.examiners;

import example.courseWorkTwo.Question;
import example.courseWorkTwo.services.questions.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random = new Random();
    private final QuestionService questionService;

    //    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new RuntimeException("amount больше кол-ва вопросов");
        }

        List<Integer> remainingQuestionsNums = new ArrayList<>(List.of());
        for (int i = 0; i < questionService.getAll().size(); i++) {
            remainingQuestionsNums.add(i);
        }
        // создан arrayList со всеми намирами вопросов
        // из него будут выбираться вопросы

        int count = 0;
        List<Integer> randomNumsArray = new ArrayList<>(List.of());
        while (count < amount) {
            int maxCount = remainingQuestionsNums.size();
            int randomNum = random.nextInt(maxCount); //индекс по массиву номеров вопросов
            Integer questionsNumber = remainingQuestionsNums.get(randomNum);


            if (randomNumsArray.isEmpty()) {
                randomNumsArray.add(questionsNumber);
                count++;
            } else if (!randomNumsArray.contains(questionsNumber)) {
                randomNumsArray.add(questionsNumber);
                count++;
                remainingQuestionsNums.remove(randomNum);
                //чтобы больше этот номер вопроса не появлялся,
                // и не делать лишние итерации
            }
        }

        List<Question> allQuestions = new ArrayList<>(List.of());
        allQuestions.addAll(questionService.getAll());


        List<Question> questions = new ArrayList<>(amount);//конечный лист

        // теперь использую полученные рандомные номера вопросов
        for (Integer questionNumber : randomNumsArray) {
            questions.add(allQuestions.get(questionNumber));

        }
        return questions;
    }
}
