package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import com.github.javaparser.ast.body.MethodDeclaration;

import static analyzer.exercises.gottasnatchemall.Constants.*;

public abstract class SetTask {

    public abstract void execute(MethodDeclaration node, OutputCollector output);

    public static SetTask getTask(String methodName) {
        return switch (methodName) {
            case TASK_1: yield new NewCollectionTask();
            case TASK_2: yield new AddCardTask();
            case TASK_3: yield new CanTradeTask();
            case TASK_4: yield new CommonCardTask();
            case TASK_5: yield new AllCardsTask();
            default: yield new NoTask();
        };
    }

}
