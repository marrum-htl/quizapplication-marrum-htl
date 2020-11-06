package module;

public class Question {
    private String questionText;
    private boolean questionAnswer;

    public Question(String questionText, boolean questionAnswer) {
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setQuestionAnswer(boolean questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

}
