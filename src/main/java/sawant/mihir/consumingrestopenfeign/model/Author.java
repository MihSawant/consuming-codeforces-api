package sawant.mihir.consumingrestopenfeign.model;

public record Author(int contestId, Member[] members, String participantType,
                     boolean ghost, long startTimeSeconds) {
}
