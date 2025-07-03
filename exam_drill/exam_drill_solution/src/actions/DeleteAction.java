package actions;

import core.Document;

public class DeleteAction implements Action{

    private final Document document;

    public DeleteAction(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.delete();
    }
}
