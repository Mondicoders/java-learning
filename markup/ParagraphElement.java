package markup;

import java.util.List;

public class ParagraphElement implements BaseElement {
    private final List<ParagraphElement> elements;
    private final String markdownTag;

    public ParagraphElement(List<ParagraphElement> elements, String markdownTag) {
        this.elements = elements;
        this.markdownTag = markdownTag;
    }

    @Override
    public void toMarkdown(StringBuilder builder) {
        builder.append(markdownTag);
        for (BaseElement element : elements) {
            element.toMarkdown(builder);
        }
        builder.append(markdownTag);
    }
}
