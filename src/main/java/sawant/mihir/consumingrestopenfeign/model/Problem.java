package sawant.mihir.consumingrestopenfeign.model;

public record Problem(int contestId, String index, String name,
                      String type, double points, int rating, String[] tags) {
}
