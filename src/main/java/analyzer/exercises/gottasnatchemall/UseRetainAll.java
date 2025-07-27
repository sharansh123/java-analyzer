package analyzer.exercises.gottasnatchemall;

import analyzer.Comment;

public class UseRetainAll extends Comment {
    @Override
    public String getKey() {
        return "java.gottasnatchemall.use_retain_all";
    }

    @Override
    public Type getType(){ return Type.ESSENTIAL; }
}
