package actions;

import core.Document;

public class ReplaceAction implements Action {

    private Document document;
    private String[] words;

    public ReplaceAction(Document document, String[] words) {
        this.document = document;
        this.words = words;
    }

    @Override
    public void execute() {
        document.replace(words);
    }
}
