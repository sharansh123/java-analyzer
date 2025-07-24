package analyzer.exercises.gottasnatchemall;

import analyzer.Comment;

import java.util.Map;

public class UseCorrectConstructor extends Comment {
    public String correctConstructor;

    public UseCorrectConstructor(String correctConstructor) {
        this.correctConstructor = correctConstructor;
    }
    @Override
    public String getKey() {
        return "java.gottasnatchemall.use_correct_constructor";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("correctConstructor", correctConstructor);
    }

    @Override
    public Type getType(){ return Type.ACTIONABLE; }
}
