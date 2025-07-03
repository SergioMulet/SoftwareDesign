package core;

import actions.*;

import java.util.HashMap;
import java.util.Map;

public class Editor {

    private Document document = new Document();
    private Macro macro;
    private boolean isMacro;
    private Map<String, Action> macros = new HashMap<>();

    public Document getDocument() {
        return document;
    }

    public void open(String path){
        executeAction(new OpenAction(path, document));
    }

    public void insert(String[] words){
        executeAction(new InsertAction(document, words));
    }

    public void delete(){
        executeAction(new DeleteAction(document));
    }

    public void replace(String[] words){
        executeAction(new ReplaceAction(document, words));
    }

    public void record(String name){
        macro = new Macro(name);
        isMacro = true;
    }

    public void stop(){
        if(!isMacro){
            System.out.println("You have no macros");
        }
        else{
            isMacro = false;
            macros.put(macro.getName(), macro);
        }
    }

    public void execute(String name){
        if(isMacro){
            macro.addAction(macros.get(name));
        }
        else{
            macros.get(name).execute();
        }
    }

    private void executeAction(Action action){
        if(isMacro){
            macro.addAction(action);
        }
        else{
            action.execute();
        }
    }


}
