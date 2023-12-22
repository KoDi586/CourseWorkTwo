package example.courseWorkTwo;

import java.util.Objects;

public class Question {
    private final String question;

    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question.equals(question1.getQuestion()) && answer.equals(question1.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "QUESTION: { "
                + question +
                " == " + answer +
                " }  ";
    }
}
