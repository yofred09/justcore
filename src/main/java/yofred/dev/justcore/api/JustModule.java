package yofred.dev.justcore.api;

/** Immutable description of a mod participating in the Just ecosystem. */
public record JustModule(String id, String displayName, String version) {
    public JustModule {
        if (id == null || !id.matches("[a-z][a-z0-9_]{1,63}")) throw new IllegalArgumentException("Invalid module id: " + id);
        if (displayName == null || displayName.isBlank()) throw new IllegalArgumentException("displayName cannot be blank");
        if (version == null || version.isBlank()) throw new IllegalArgumentException("version cannot be blank");
    }
}
