package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.AvoidUsingSameSet;
import analyzer.exercises.gottasnatchemall.UseCorrectFunc;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;

import static analyzer.exercises.gottasnatchemall.Constants.COLLECTION_NAME;

public class CanTradeTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {
        if (isFuncInsideLoop(node, "remove")) {
            output.addComment(new UseCorrectFunc("removeAll"));
        } else if (isUsingFunc(node, "removeAll") && !isUsingNewSets(node)) {
            output.addComment(new AvoidUsingSameSet());
        }
    }

    public boolean isUsingFunc(MethodDeclaration node, String func) {
        return node.findAll(MethodCallExpr.class).stream().anyMatch(e -> e.getNameAsString().equals(func));
    }

    public boolean isUsingNewSets(MethodDeclaration node) {
        return node.findAll(ObjectCreationExpr.class)
                .stream().filter(expr -> expr.getTypeAsString().contains(COLLECTION_NAME)).count() == 2;
    }
}
