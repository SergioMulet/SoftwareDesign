package actions;

import core.Document;

import java.util.ArrayList;
import java.util.List;

public class Macro implements Action {

    List<Action> actions = new ArrayList<>();
    private String name;

    public Macro(String name) {
        this.name = name;
    }

    public void addAction(Action a){
        actions.add(a);
    }

    public void execute(){
        for(Action action : actions){
            action.execute();
        }
    }

    public String getName(){
        return name;
    }
}
