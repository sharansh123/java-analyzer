package analyzer.exercises.gottasnatchemall;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.exercises.gottasnatchemall.tasks.SetTask;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import static analyzer.exercises.gottasnatchemall.Constants.EXERCISE_NAME;

public class GottaSnatchEmAllAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {


    @Override
    public void analyze(Solution solution, OutputCollector output) {
        for(CompilationUnit cu : solution.getCompilationUnits()) {
            cu.accept(this, output);
        }

        if(output.getComments().isEmpty()){
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(MethodDeclaration node, OutputCollector output) {
        String methodName = node.getNameAsString();
        SetTask.getTask(methodName).execute(node, output);
        super.visit(node, output);
//        switch(methodName){
//            case TASK_1 -> {
//                List<ObjectCreationExpr> objectCreationExprs = node.findAll(ObjectCreationExpr.class);
//                long validConstructors = objectCreationExprs.stream()
//                        .filter(this::matchIfCollectionIsUsed)
//                        .count();
//
//            }
//        }
    }



}
