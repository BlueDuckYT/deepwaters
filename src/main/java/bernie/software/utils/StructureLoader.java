package bernie.software.utils;

import com.google.gson.Gson;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class StructureLoader {
    ResourceLocation loc;
    String[] lines;
    ArrayList<blockHolder> holders = new ArrayList<>();
    public StructureLoader(ResourceLocation location) {
        loc=location;
    }
    public StructureLoader(String location) {
        loc=GeneralUtils.Location(location);
    }
    public StructureLoader(String namespace,String location) {
        loc=new ResourceLocation(namespace,location);
    }
    public Structure toStructure() {
        readFile();
        return null;
    }
    protected void readFile() {
        try
        {
            Gson GSON = new Gson();
            InputStream inputstream = new FileInputStream(loc.getPath());
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputstream, writer, StandardCharsets.UTF_8);
            String fileOutputString = writer.toString();
            lines=fileOutputString.split("\n");
        }
        catch(Exception e)
        {
        }
    }
    public static class Structure {
        ArrayList<blockHolder> holders=new ArrayList<>();
        public Structure() {
        }
        public void addBlock(blockHolder block) {
            holders.add(block);
        }
        public void place(BlockPos pos, World world) {
            for (blockHolder holder:holders) {
                if (holder.shouldPlace()) {
                    world.setBlockState(pos.add(holder.pos),holder.state);
                }
            }
        }
    }
    public static class blockHolder {
        Block block;
        BlockState state;
        BlockPos pos;
        float generateChance;
        Random rand;
        public blockHolder(ResourceLocation block, String state, BlockPos pos, float generateChance, Random rand) {
            this.block = Registry.BLOCK.getOrDefault(block);
            for (Object obj:this.block.getStateContainer().getValidStates().toArray()) {
                if (obj.toString().equals(this.block.toString()+state)) {
                    this.state=((BlockState)obj);
                }
            }
            this.pos = pos;
            this.generateChance = generateChance;
            this.rand = rand;
        }
        public boolean shouldPlace() {
            return rand.nextDouble()*100<=generateChance;
        }
    }
}
