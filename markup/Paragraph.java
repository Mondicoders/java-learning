package markup;

import java.util.List;

public class Paragraph implements BaseElement {
    private final List<BaseElement> elements;

    public Paragraph(List<BaseElement> elements) {
        this.elements = elements;
    }

    @Override
    public void toMarkdown(StringBuilder builder) {
        for (BaseElement element : elements) {
            element.toMarkdown(builder);
        }
    }
}
