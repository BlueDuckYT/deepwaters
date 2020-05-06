package bernie.software.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;

import java.util.Optional;

public class ForceSpawnCommand {

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("forcespawn")
                .requires((cs) -> cs.hasPermissionLevel(2))
                .then(Commands.argument("entity", EntitySummonArgument.entitySummon()).suggests(SuggestionProviders.SUMMONABLE_ENTITIES)
                        .executes((p_198738_0_) -> {
                            return summonEntity(p_198738_0_.getSource(), EntitySummonArgument.getEntityId(p_198738_0_, "entity"), new StringTextComponent(""), new CompoundNBT(), true);
                        })
                        .then(Commands.argument("reason", MessageArgument.message())
                                .executes((p_198735_0_) -> {
                                    return summonEntity(p_198735_0_.getSource(), EntitySummonArgument.getEntityId(p_198735_0_, "entity"), (StringTextComponent) MessageArgument.getMessage(p_198735_0_, "reason"), new CompoundNBT(), true);
                                }))
                );
    }

    private static int summonEntity(CommandSource source, ResourceLocation type, StringTextComponent pos, CompoundNBT nbt, boolean randomizeProperties) throws CommandSyntaxException {
        CompoundNBT compoundnbt = nbt.copy();
        compoundnbt.putString("id", type.toString());
        Optional<EntityType<?>> value = Registry.ENTITY_TYPE.getValue(type);
        if (value.get() == null) {
            return 0;
        } else {
            EntityType<?> entityType = value.get();
            SpawnReason spawnReason = SpawnReason.valueOf(pos.getText());
            entityType.spawn(source.getWorld(), compoundnbt, null, source.asPlayer(), new BlockPos(source.getPos()), spawnReason, false, false);
        }
        return 1;

    }
}
