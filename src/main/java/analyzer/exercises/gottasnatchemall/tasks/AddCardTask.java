package analyzer.exercises.gottasnatchemall.tasks;


import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.AvoidUsingContains;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.IfStmt;

import java.util.Objects;

import static analyzer.exercises.gottasnatchemall.Constants.CONTAINS;

public class AddCardTask extends SetTask {

    @Override
    @SuppressWarnings("unchecked")
    public void execute(MethodDeclaration node, OutputCollector output) {

           node.findAll(MethodCallExpr.class)
                    .stream()
                   .filter(methodCallExpr -> methodCallExpr.getNameAsString().equalsIgnoreCase(CONTAINS))
                   .filter(methodCallExpr -> methodCallExpr.findAncestor(IfStmt.class).isPresent())
                   .findFirst()
                   .ifPresent(
                           x -> output.addComment(new AvoidUsingContains())
                   );
    }
}
