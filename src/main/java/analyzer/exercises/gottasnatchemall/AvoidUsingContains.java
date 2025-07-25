package analyzer.exercises.gottasnatchemall;


import analyzer.Comment;

import java.util.Map;

public class AvoidUsingContains extends Comment {
    @Override
    public String getKey() {
        return "java.gottasnatchemall.avoid_using_contains";
    }

    @Override
    public Type getType(){ return Type.ACTIONABLE; }

}
