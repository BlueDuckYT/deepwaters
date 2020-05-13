package bernie.software.utils;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.ArrayList;

public class CollisionUtils {
    public static class RotateableShape {
        private ArrayList<Box> boxes = new ArrayList<>();

        public RotateableShape(double minX,double minY,double minZ,double width,double height,double depth) {
            boxes.add(new Box(minX,minY,minZ,minX+width,minY+height,minZ+depth));
        }
        public void addBox(double minX,double minY,double minZ,double width,double height,double depth) {
            boxes.add(new Box(minX,minY,minZ,minX+width,minY+height,minZ+depth));
        }
        public RotateableShape rotate(Direction dir) {
            if (dir.equals(Direction.SOUTH)) {
            } else if (dir.equals(Direction.EAST)) {
                for (int i=0;i<boxes.size();i++) {
                    Box box=boxes.get(i);
                    double minX=box.minZ;
                    double minY=box.minY;
                    double minZ=box.minX;
                    double maxX=box.maxZ;
                    double maxY=box.maxY;
                    double maxZ=box.maxX;
                    boxes.set(i,new Box(minX,minY,minZ,maxX,maxY,maxZ));
                }
            } else if (dir.equals(Direction.NORTH)) {
                for (int i=0;i<boxes.size();i++) {
                    Box box=boxes.get(i);
                    double minX=box.minX;
                    double minY=box.minY;
                    double minZ=16-box.maxZ;
                    double maxX=box.maxX;
                    double maxY=box.maxY;
                    double maxZ=16-box.minZ;
                    boxes.set(i,new Box(minX,minY,minZ,maxX,maxY,maxZ));
                }
            } else if (dir.equals(Direction.WEST)) {
                for (int i=0;i<boxes.size();i++) {
                    Box box=boxes.get(i);
                    double minX=16-box.maxZ;
                    double minY=box.minY;
                    double minZ=box.minX;
                    double maxX=16-box.minZ;
                    double maxY=box.maxY;
                    double maxZ=box.maxX;
                    boxes.set(i,new Box(minX,minY,minZ,maxX,maxY,maxZ));
                }
            }
            return this;
        }
        public VoxelShape toVoxel() {
            VoxelShape shape1=null;
            for (Box box:boxes) {
                try {
                    shape1=VoxelShapes.or(shape1,Block.makeCuboidShape(box.minX,box.minY,box.minZ,box.maxX,box.maxY,box.maxZ));
                } catch (Exception err) {
                    shape1=Block.makeCuboidShape(box.minX,box.minY,box.minZ,box.maxX,box.maxY,box.maxZ);
                }
            }
            if (shape1.equals(null)) {
                throw new RuntimeException(new NullPointerException("Cannot convert nothing to a voxel shape. (if this is an actual crash, idk how you are seeing this btw)"));
            }
            return shape1;
        }

        @Override
        public String toString() {
            String boxes="";
            for (Box box:this.boxes) {
                boxes+=box+",";
            }
            return "RotateableShape{" +
                    "boxes=" + boxes +
                    '}';
        }
    }
    public static class Box {
        double minX;
        double minY;
        double minZ;
        double maxX;
        double maxY;
        double maxZ;

        public Box(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
            this.minX = minX;
            this.minY = minY;
            this.minZ = minZ;
            this.maxX = maxX;
            this.maxY = maxY;
            this.maxZ = maxZ;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "minX=" + minX +
                    ", minY=" + minY +
                    ", minZ=" + minZ +
                    ", maxX=" + maxX +
                    ", maxY=" + maxY +
                    ", maxZ=" + maxZ +
                    '}';
        }
    }
}
