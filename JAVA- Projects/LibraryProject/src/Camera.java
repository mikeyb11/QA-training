
public class Camera extends MediaResources
{
	private float mMegaPixelOfCamera;
	
	public Camera(String name, int checkoutCost, int damageCost, float megaPixel) 
	{
		super(name, checkoutCost, damageCost);
		
		mType = TypeOfItem.CAMERA;
	}

	public float getMegaPixelOfCamera() { return mMegaPixelOfCamera; }
}
