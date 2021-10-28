package factory.task3.createdocument;

import factory.task3.documents.IDocument;
import factory.task3.documents.TextDocument;

public class CreateTextDocument implements ICreateDocument{
    @Override
    public IDocument createNew() {
        return new TextDocument();
    }

    @Override
    public IDocument open() {
        return new TextDocument();
    }
}
