package actions;

import core.Document;

public class OpenAction implements Action {

    private String fileName;
    private Document doc;

    public OpenAction(String fileName, Document doc) {
        this.fileName = fileName;
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.loadText(fileName);
    }
}
