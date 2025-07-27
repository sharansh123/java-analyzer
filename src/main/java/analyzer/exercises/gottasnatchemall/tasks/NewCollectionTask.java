package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import analyzer.exercises.gottasnatchemall.UseCorrectConstructor;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;

import java.util.Collection;
import java.util.stream.Collectors;

import static analyzer.exercises.gottasnatchemall.Constants.COLLECTION_NAME;
import static analyzer.exercises.gottasnatchemall.Constants.CONSTRUCTOR_ARGUMENT;

public class NewCollectionTask extends SetTask {
    @Override
    public void execute(MethodDeclaration node, OutputCollector output) {

        //All Possible Variables of List Type.
        var allVariables = node.findAll(VariableDeclarationExpr.class).stream()
                .map(VariableDeclarationExpr::getVariables)
                .flatMap(Collection::stream)
                .filter(v -> v.getType().isReferenceType())
                .map(v -> v.getName().asString())
                .collect(Collectors.toSet());

        allVariables.add(CONSTRUCTOR_ARGUMENT);

       var validConstructors = node.findAll(ObjectCreationExpr.class)
                .stream()
                .filter(expr -> expr.getTypeAsString().contains(COLLECTION_NAME))
                .filter(expr -> expr.getArguments().size() == 1)
               .filter(expr -> allVariables.contains(expr.getArgument(0).asNameExpr().getNameAsString()))
               .findFirst();

        if(validConstructors.isEmpty()) output.addComment(new UseCorrectConstructor());
    }
}
