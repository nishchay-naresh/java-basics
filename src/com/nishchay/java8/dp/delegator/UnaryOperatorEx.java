package com.nishchay.java8.dp.delegator;

import java.util.function.UnaryOperator;

public class UnaryOperatorEx {

    public static void main(String[] args) {

        hardCodedEnrichmentEx();
        System.out.println("-----------------------------");
        unaryOperatorEnrichmentEx();

    }

    private static void hardCodedEnrichmentEx() {
        Task baseVersion = new DefaultTaskImpl();
        Task enrichedVersion = new DelegatedTask(baseVersion);
        doingTasks(enrichedVersion);
    }

    private static void doingTasks(Task enrichedVersion) {
        enrichedVersion.doTask1();
        enrichedVersion.doTask2();
    }

    private static void unaryOperatorEnrichmentEx() {
        UnaryOperator<Task> enrichmentLogic = e -> new DelegatedTask(e);
        doingEnrichmentThing(new DefaultTaskImpl(), enrichmentLogic);
    }

    /**
     * This is a generic methods, takes below two params, and then later doing the things for enriched version of object
     *
     * @param baseVersion
     * @param enrichmentLogic
     */
    private static void doingEnrichmentThing(DefaultTaskImpl baseVersion, UnaryOperator<Task> enrichmentLogic) {
        Task enrichedVersion = enrichmentLogic.apply(baseVersion);
        doingTasks(enrichedVersion);
    }


}
