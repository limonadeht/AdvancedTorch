package lychemon.advtorch.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTv extends ModelBase
{
	public static ModelTv instance = new ModelTv();

  //fields
    ModelRenderer tvBase1;
    ModelRenderer tvPillar;
    ModelRenderer tvScreen;

  public ModelTv()
  {
    textureWidth = 64;
    textureHeight = 32;

      tvBase1 = new ModelRenderer(this, 0, 0);
      tvBase1.addBox(0F, 0F, 0F, 8, 1, 4);
      tvBase1.setRotationPoint(-4F, 23F, -2F);
      tvBase1.setTextureSize(64, 32);
      tvBase1.mirror = true;
      setRotation(tvBase1, 0F, 0F, 0F);
      tvPillar = new ModelRenderer(this, 25, 0);
      tvPillar.addBox(0F, 0F, 0F, 2, 5, 1);
      tvPillar.setRotationPoint(-1F, 18F, 0F);
      tvPillar.setTextureSize(64, 32);
      tvPillar.mirror = true;
      setRotation(tvPillar, 0F, 0F, 0F);
      tvScreen = new ModelRenderer(this, 32, 0);
      tvScreen.addBox(0F, 0F, 0F, 15, 9, 1);
      tvScreen.setRotationPoint(-7F, 11F, -1F);
      tvScreen.setTextureSize(64, 32);
      tvScreen.mirror = true;
      setRotation(tvScreen, 0F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    tvBase1.render(f5);
    tvPillar.render(f5);
    tvScreen.render(f5);
  }

  public void renderModel(float f)
  {
	    tvBase1.render(f);
	    tvPillar.render(f);
	    tvScreen.render(f);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
