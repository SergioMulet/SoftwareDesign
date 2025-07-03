package actions;

import core.Document;

public class InsertAction implements Action{

    private final String[] words;
    private final Document document;

    public InsertAction(Document document, String[] words) {
        this.words = words;
        this.document = document;
    }

    @Override
    public void execute() {
        document.insert(words);
    }
}
