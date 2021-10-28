package factory.task3.documents;

public class ImageDocument implements IDocument {
    private double size;
    private String name;
    private String extension;

    public ImageDocument(double size, String name, String extension) {
        this.size = size;
        this.name = name;
        this.extension = extension;
    }

    public ImageDocument() {
        this(0, "New Image Document", "img");
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getExtension() {
        return extension;
    }
}
