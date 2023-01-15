package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Launcher implements Callable<Integer> {
    @Option(names = {"-c", "--classes"}, description = "Permet de renseigner les classes d'ou faire partir l'analyse", required = true)
    private ArrayList<Class> classes;

    @Option(names = {"-g", "--graph-type"}, description = "Permet de selectionner le type de graph que l'on souhaite en sortie")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public Integer call() {
        UmlGraph graph = new UmlGraph(classes);
        String output = graph.as(graphType);
        System.out.println(output);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}


