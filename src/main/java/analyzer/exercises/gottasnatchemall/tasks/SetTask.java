package analyzer.exercises.gottasnatchemall.tasks;

import analyzer.OutputCollector;
import com.github.javaparser.ast.body.MethodDeclaration;

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

}
