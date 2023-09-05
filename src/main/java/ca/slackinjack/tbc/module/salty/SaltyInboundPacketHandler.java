package ca.slackinjack.tbc.module.salty;

import ca.slackinjack.tbc.TBC;
import ca.slackinjack.tbc.util.packethandler.InboundPacketHandlerBase;
import ca.slackinjack.tbc.util.packethandler.PacketEnum;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S3CPacketUpdateScore;

public class SaltyInboundPacketHandler implements InboundPacketHandlerBase {

    private final Salty SALTY;
    private final Minecraft MINECRAFT = Minecraft.getMinecraft();

    public SaltyInboundPacketHandler(Salty saltyIn) {
        SALTY = saltyIn;
    }

    @Override
    public boolean processPacket(PacketEnum packetType, Packet thePacket) {
        switch (packetType) {
            case S3C:
                S3CPacketUpdateScore s3cPacket = (S3CPacketUpdateScore) thePacket;
                String objectiveName = TBC.getUtilPublic().getUnstylizedText(s3cPacket.getObjectiveName()); // not used on mineplex
                String playerName = TBC.getUtilPublic().getUnstylizedText(s3cPacket.getPlayerName()); //text on scoreboard
                int scoreValue = s3cPacket.getScoreValue(); //row
                //System.out.println("ObjName: " + s3cPacket.getObjectiveName() + "; PlayerName: " + s3cPacket.getPlayerName() + "; ScoreVal: " + s3cPacket.getScoreValue());
                if (playerName.contains("MS-") || playerName.contains("SWAT")) {
                    // Minestrike init
                }
                break;
        }

        return true;
    }
}
