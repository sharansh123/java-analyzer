package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

import static analyzer.exercises.gottasnatchemall.Constants.*;

public abstract class SetTask {

    public abstract void execute(MethodDeclaration node, OutputCollector output);

    public static SetTask getTask(String methodName) {
        return switch (methodName) {
            case TASK_1 -> new NewCollectionTask();
            case TASK_2 -> new AddCardTask();
            case TASK_3 -> new CanTradeTask();
            case TASK_4 -> new CommonCardTask();
            case TASK_5 -> new AllCardsTask();
            default -> new NoTask();
        };
    }

    //Check If the 'addAll' & 'retainAll' are used within a loop.
    @SuppressWarnings("unchecked")
    public boolean isFuncInsideLoop(MethodDeclaration node, String func) {
        //Looking For retainAll inside a loop
        return node.findAll(MethodCallExpr.class)
                .stream()
                .filter(expr -> expr.getNameAsString().equals(func))
                .anyMatch(expr ->
                        expr.findAncestor(ForStmt.class).isPresent()
                                || expr.findAncestor(ForEachStmt.class).isPresent()
                                || expr.findAncestor(WhileStmt.class).isPresent()
                                || expr.findAncestor(DoStmt.class).isPresent()
                );
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
