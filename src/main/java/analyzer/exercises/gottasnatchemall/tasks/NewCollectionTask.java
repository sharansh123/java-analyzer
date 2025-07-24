package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseCorrectConstructor;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;


import static analyzer.exercises.gottasnatchemall.Constants.COLLECTION_NAME;
import static analyzer.exercises.gottasnatchemall.Constants.CORRECT_CONSTRUCTOR;

public class NewCollectionTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {
        long validConstructors = node.findAll(ObjectCreationExpr.class)
                .stream()
                .filter(expr -> expr.getType().toString().contains(COLLECTION_NAME))
                .filter(expr -> expr.getArguments().size() == 1)
                .filter(expr -> expr.getArgument(0).asNameExpr().resolve().getType().isReference())
                .count();

        if(validConstructors == 0) output.addComment(new UseCorrectConstructor(CORRECT_CONSTRUCTOR));
    }
}
