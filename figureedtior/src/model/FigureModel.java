package model;

import javax.swing.ImageIcon;
import java.util.Observable;

public class FigureModel extends Observable
{
    private ImageIcon img = null;
    private String cap = null;

    public ImageIcon getImage() {
        //Returns the Figure Models' image
        return img;
    }

    /**
     * Sets the image to the given non-null ImageIcon.
     *
     * @param newImage The ImageIcon must be non-null
     *
     * @throws IllegalArgumentException if the ImageIcon is null
     */
    public void setImage(ImageIcon newImage) {
        //Sets the Figure Models' image
        if (newImage == null){
            throw new IllegalArgumentException("Image must be non-null!");
        }
        img = newImage;
        setChanged();
        notifyObservers();
    }

    public String getCaption() {
        //Returns the Figure Models' caption
        return cap;
    }

    /**
     * Sets the caption to the given non-null and non-empty String.
     *
     * @param newCaption The String must be non-null and non-empty
     *
     * @throws IllegalArgumentException if the String is null or empty
     */
    public void setCaption(String newCaption) {
        //Sets the Figure Models' caption
        if (newCaption == null){
            throw new IllegalArgumentException("Caption must be non-null!");
        }
        if (newCaption.equals("")){
            throw new IllegalArgumentException("Caption must be non-empty!");
        }
        cap = newCaption;
        setChanged();
        notifyObservers(newCaption);
    }

    /**
     * Returns true if this figure is complete, meaning its Image 
     * is non-null and its caption is non-null and non-empty, and
     * false otherwise.
     *
     * @return True if this figure is complete and false otherwise
     */
    public boolean isComplete() {
        //Returns whether the figure is complete
        return (img != null && cap != null);
    }
}
