package analyzer.exercises.gottasnatchemall;

import analyzer.Comment;

import java.util.Map;

public class UseCorrectConstructor extends Comment {

    @Override
    public String getKey() {
        return "java.gottasnatchemall.use_correct_constructor";
    }

    @Override
    public Type getType(){ return Type.ACTIONABLE; }
}
