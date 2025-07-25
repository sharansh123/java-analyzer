package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseCorrectConstructor;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import static analyzer.exercises.gottasnatchemall.Constants.COLLECTION_NAME;
import static analyzer.exercises.gottasnatchemall.Constants.CONSTRUCTOR_ARGUMENT;

public class NewCollectionTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {

       long validConstructors = node.findAll(ObjectCreationExpr.class)
                .stream()
                .filter(expr -> expr.getTypeAsString().contains(COLLECTION_NAME))
                .filter(expr -> expr.getArguments().size() == 1)
               .filter(expr -> expr.getArgument(0).asNameExpr().getNameAsString().equals(CONSTRUCTOR_ARGUMENT))
               .count();

        if(validConstructors != 1) output.addComment(new UseCorrectConstructor());
    }
}
