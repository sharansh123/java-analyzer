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
    public void execute(MethodDeclaration node, OutputCollector output) {
           long validCount = node.findAll(IfStmt.class)
                    .stream()
                    .map(IfStmt::getCondition)
                   .filter(expr -> !expr.findAll(MethodCallExpr.class).isEmpty())
                   .map(Expression::asMethodCallExpr)
                   .filter(methodCallExpr -> methodCallExpr.getName().asString().equalsIgnoreCase(CONTAINS))
                   .count();

           if (validCount > 0) output.addComment(new AvoidUsingContains());
    }
}
