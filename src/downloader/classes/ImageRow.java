package downloader.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ImageRow {

    SimpleStringProperty imageName;
    SimpleIntegerProperty imageWidth, imageHeight;

    public ImageRow(String _imageName, int _imageWidth, int _imageHeight)
    {
        imageName = new SimpleStringProperty();
        imageWidth = new SimpleIntegerProperty();
        imageHeight = new SimpleIntegerProperty();

        setImageHeight(_imageHeight);
        setImageName(_imageName);
        setImageWidth(_imageWidth);

    }

    public String getImageName() {
        return imageName.get();
    }

    public SimpleStringProperty imageNameProperty() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName.set(imageName);
    }

    public int getImageWidth() {
        return imageWidth.get();
    }

    public SimpleIntegerProperty imageWidthProperty() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth.set(imageWidth);
    }

    public int getImageHeight() {
        return imageHeight.get();
    }

    public SimpleIntegerProperty imageHeightProperty() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight.set(imageHeight);
    }
}
