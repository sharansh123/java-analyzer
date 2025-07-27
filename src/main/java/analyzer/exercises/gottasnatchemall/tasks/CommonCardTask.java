package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseRetainAll;
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
        if(!isRetainAllPresent(node) && !isUsingStreamForIntersection(node)) {
            output.addComment(new UseRetainAll());
        }
    }

    @SuppressWarnings("unchecked")
    public boolean isRetainAllPresent(MethodDeclaration node) {
        //Looking For retainAll inside a loop
        return node.findAll(MethodCallExpr.class)
                .stream()
                .filter(expr -> expr.getNameAsString().equals("retainAll"))
                .anyMatch(expr ->
                   expr.findAncestor(ForStmt.class).isPresent()
                || expr.findAncestor(ForEachStmt.class).isPresent()
                || expr.findAncestor(WhileStmt.class).isPresent()
                || expr.findAncestor(DoStmt.class).isPresent()
                );
    }

    public boolean isUsingStreamForIntersection(MethodDeclaration node) {
        //Find all the filter() method calls.
        // filter() can only be used with stream().
        return node.findAll(MethodCallExpr.class)
                .stream()
                .filter(expr -> expr.getNameAsString().equals("filter"))
                .anyMatch(expr -> searchInLambda(expr.getArgument(0)) || searchForReference(expr.getArgument(0)));
    }

    public boolean searchInLambda(Expression expression) {
        //checking for set contains() method inside filter()
        if(expression.isLambdaExpr()){
            return expression
                    .asLambdaExpr()
                    .findAll(MethodCallExpr.class)
                    .stream()
                    .anyMatch(expr -> expr.getNameAsString().equals("contains"));

        }
        return false;
    }

    public boolean searchForReference(Expression expression) {
        // checking for usage of setA::contains inside filter()
        if(expression.isMethodReferenceExpr()){
            return expression
                    .asMethodReferenceExpr()
                    .getIdentifier()
                    .contains("contains");
        }
        return false;
    }
}
