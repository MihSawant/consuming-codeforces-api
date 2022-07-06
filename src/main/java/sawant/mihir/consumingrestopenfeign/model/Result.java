package sawant.mihir.consumingrestopenfeign.model;

public record Result(long id, int contestId, long creationTimeSeconds,
                     long relativeTimeSeconds, Problem problem, Author author,
                     String programmingLanguage, String verdict, String testset,
                     int passedTestCount, int timeConsumedMillis, int memoryConsumedBytes) {
}
