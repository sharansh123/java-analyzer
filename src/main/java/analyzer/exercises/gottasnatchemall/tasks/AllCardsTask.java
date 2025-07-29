package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseCorrectFunc;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AllCardsTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {
        if(!isFuncInsideLoop(node, "addAll") && !isUsingStreamForUnion(node)) {
            output.addComment(new UseCorrectFunc("addAll"));
        }
    }

    public boolean isUsingStreamForUnion(MethodDeclaration node){

        long countOfStreamUsed = node.findAll(MethodCallExpr.class)
                .stream()
                .filter(callExpr -> callExpr.getNameAsString().equals("stream"))
                .count();

        boolean streamFound = node.findAll(MethodCallExpr.class)
                .stream()
                .anyMatch(callExpr -> callExpr.getNameAsString().equals("concat") && scopeFoundWithName(callExpr, "Stream"));

        return streamFound && countOfStreamUsed == 2;
    }

    public boolean scopeFoundWithName(MethodCallExpr expr, String name){
        if(expr.getScope().isPresent() && expr.getScope().get().isNameExpr()) {
            return expr.getScope().get().asNameExpr().getNameAsString().equals(name);
        }
        return false;
    }
}
