package factory.task3.createdocument;

import factory.task3.documents.IDocument;
import factory.task3.documents.ImageDocument;

public class CreateImageDocument implements ICreateDocument{
    @Override
    public IDocument createNew() {
        return new ImageDocument();
    }

    @Override
    public IDocument open() {
        return new ImageDocument();
    }
}
