package bernie.software.item;

public class DeepWatersIngotItem extends DeepWatersItem {
	public int MatDurability;
	public int MatStrength;
	public float MatWeight;
	public int MatColor;
	
	public DeepWatersIngotItem(int matDurability, int matStrength, float matWeight, int matColor) {
		MatDurability = matDurability;
		MatStrength = matStrength;
		MatWeight = 5-matWeight;
		MatColor = matColor;
	}
}