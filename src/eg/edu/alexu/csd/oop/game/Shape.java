/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dell
 */
public abstract class Shape implements GameObject {
    int x ,y,end;
    private final boolean visible;
    private int type;
    private String path;
    private Color color;
    
    

   
    	private static final int MAX_MSTATE = 1;

 	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    public Shape(int posX, int posY,int end, String path, Color color,int type) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.path=path;
        this.visible = true;
        this.end = end;
        this.color=color;
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
             spriteImages[0]= ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       public int getType() {
        return type;
    }
     public void setType(int type) {
        this.type = type;
    }
   

@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int mX) {
		this.x = mX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
            if(this.getType()!=3 && this.getType()!=2)
		this.y = mY;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

    public Color getColor() {
        return color;
    }
    public String getPath() {
        return path;
    }
        

	@Override
	public boolean isVisible() {
		return visible;
	}
   public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
