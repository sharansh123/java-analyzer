package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseCorrectFunc;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.WhileStmt;


public class CommonCardTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {
        if(!isFuncInsideLoop(node, "retainAll") && !isUsingStreamForIntersection(node)) {
            output.addComment(new UseCorrectFunc("retainAll"));
        }
    }

    public boolean isUsingStreamForIntersection(MethodDeclaration node) {
        //Find all the filter() method calls.
        // filter() can only be used with stream().
        return node.findAll(MethodCallExpr.class)
                .stream()
                .filter(expr -> expr.getNameAsString().equals("filter"))
                .anyMatch(expr -> searchInLambda(expr.getArgument(0)) || searchForReference(expr.getArgument(0)));
    }


}
