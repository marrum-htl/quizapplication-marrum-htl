package module;

public class QuestionCatalog {
    private Question[] questions;

    public QuestionCatalog()
    {

        // todo: read questions from file
        questions = new Question[] {
                new Question("Die Sonne geht im Süden auf.", false),
                new Question("Der 100-Meter Weltrekord der Männer liegt bei 9.77 Sekunden.", false),
                new Question("Der am Tiefsten gelegene Meeresgrund beträgt 2000m.", false),

        };
    }

    public Question getQuestion(Question index) {
        return questions[index];
    }

}
