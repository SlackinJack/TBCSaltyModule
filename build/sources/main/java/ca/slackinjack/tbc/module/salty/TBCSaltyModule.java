package ca.slackinjack.tbc.module.salty;

import ca.slackinjack.tbc.util.module.ModuleBase;
import ca.slackinjack.tbc.util.packethandler.InboundPacketHandlerBase;
import java.util.UUID;
import net.minecraft.command.CommandBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TBCSaltyModule.MODID, version = TBCSaltyModule.VERSION, dependencies = TBCSaltyModule.DEPENDENCIES, acceptedMinecraftVersions = TBCSaltyModule.MCVERSION)
public class TBCSaltyModule extends ModuleBase {

    // Forge
    public static final String MODID = "....";
    public static final String VERSION = "1.0.0";
    public static final String DEPENDENCIES = "required-after:.@[3.2.0,)";
    public static final String MCVERSION = "1.8.9";

    // Module
    private static final Salty SALTY = new Salty();
    private static final SaltyInboundPacketHandler SALTY_PACKET_HANDLER = new SaltyInboundPacketHandler(SALTY);

    public TBCSaltyModule() {
        super("Salty Server Support", UUID.randomUUID(), false, null, null, true, "saltyshits.zapto.org", SALTY);
        this.registerModule();
    }

    @Override
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent e) {
    }

    @Override
    public void onFMLInitializationEvent(FMLInitializationEvent e) {
    }

    @Override
    public void onFMLPostInitializationEvent(FMLPostInitializationEvent e) {
    }

    @Override
    public InboundPacketHandlerBase getModuleInboundPacketHandler() {
        return SALTY_PACKET_HANDLER;
    }

    @Override
    public CommandBase getModuleCommand() {
        return null;
    }

    @Override
    public String getModuleCommandString() {
        return null;
    }
}
