package github.kasuminova.novaeng.client.gui.widget.msa.slot;

import github.kasuminova.novaeng.NovaEngineeringCore;
import github.kasuminova.novaeng.common.container.slot.AssemblySlotManager;
import github.kasuminova.novaeng.common.container.slot.SlotCPUItemHandler;
import github.kasuminova.novaeng.common.container.slot.SlotConditionItemHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class SlotCPU extends SlotAssembly<SlotCPUItemHandler> {
    public static final ResourceLocation TEX_LOCATION = new ResourceLocation(NovaEngineeringCore.MOD_ID, "textures/gui/msa_cpu.png");
    public static final int TEX_X = 122;
    public static final int TEX_Y = 0;

    public static final int UNAVAILABLE_TEX_X = 25;
    public static final int UNAVAILABLE_TEX_Y = 7;

    protected final int displayID;

    public SlotCPU(final int displayID, final int slotID, final AssemblySlotManager slotManager) {
        super(slotID, slotManager);
        this.displayID = displayID;
        this.texLocation = TEX_LOCATION;
        this.unavailableTexLocation = TEX_LOCATION;
        this.textureX = TEX_X;
        this.textureY = TEX_Y;
        this.unavailableTextureX = UNAVAILABLE_TEX_X;
        this.unavailableTextureY = UNAVAILABLE_TEX_Y;
    }

    @Override
    protected SlotCPUItemHandler getSlot() {
        SlotConditionItemHandler slot = slotManager.getSlot("cpu", slotID);
        return slot instanceof SlotCPUItemHandler ? (SlotCPUItemHandler) slot : null;
    }

    @Override
    public <SLOT extends SlotAssembly<?>> SlotCPU dependsOn(SLOT dependency) {
        return (SlotCPU) super.dependsOn(dependency);
    }

    @Override
    public String getSlotDescription() {
        return I18n.format("gui.modular_server_assembler.assembly.cpu.name", displayID);
    }

}