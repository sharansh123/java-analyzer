package analyzer.exercises.gottasnatchemall;

import analyzer.Comment;

import java.util.Map;

public class UseCorrectFunc extends Comment {
    String correctFunc;
    public UseCorrectFunc(String correctFunc) {
        this.correctFunc = correctFunc;
    }
    @Override
    public String getKey() {
        return "java.gottasnatchemall.use_correct_func";
    }

    @Override
    public Map<String, String> getParameters(){
        return Map.of(
                "correct_func", correctFunc
        );
    }
    @Override
    public Type getType(){ return Type.ESSENTIAL; }
}
