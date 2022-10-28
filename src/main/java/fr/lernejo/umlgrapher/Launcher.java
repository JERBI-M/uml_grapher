package fr.lernejo.umlgrapher;

    import picocli.CommandLine;
    import picocli.CommandLine.Option;

    import java.util.concurrent.Callable;

    public class Launcher implements Callable<Integer> {
    @Option(names = {"-c", "--classes"}, description = "Fill in the classes used for the analysis.", required = true)
    private final Class [] allClasses = null;
    @Option(names = {"-g", "--graph-type"}, description = "Allows you to select the type of graph you want.")
    private final GraphType graphtype = GraphType.Mermaid;

    @Override
    public Integer call() {
        UmlGraph umlgraph = new UmlGraph(allClasses);
        System.out.println(umlgraph.as(null));
        return 0;
    }

    public static void main(String... args) {
        try {
            int exitCode = new CommandLine(new Launcher()).execute(args);
            System.exit(exitCode);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }
}

