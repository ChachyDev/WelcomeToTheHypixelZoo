package club.chachy.zoo.config;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

@SuppressWarnings("FieldMayBeFinal")
public class ZooModConfig extends Vigilant {
    @Property(
        type = PropertyType.SWITCH, name = "Enabled/Disabled",
        description = "Toggles playing \"Welcome to the Hypixel Zoo\" on join to the Hypixel Network",
        category = "General", subcategory = "General"
    )
    private boolean isModEnabled = true;

    public ZooModConfig() {
        super(new File("./config/hypixelzoo.toml"));
    }

    public boolean isModEnabled() {
        return isModEnabled;
    }
}
