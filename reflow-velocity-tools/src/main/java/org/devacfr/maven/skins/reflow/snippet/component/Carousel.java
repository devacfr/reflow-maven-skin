/*
 * Copyright 2012-2020 Christophe Friederich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.maven.skins.reflow.snippet.component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.devacfr.maven.skins.reflow.snippet.SnippetContext;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Evaluator;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class Carousel extends SnippetComponent<Carousel> {

    private List<Slide> slides = Collections.emptyList();

    public static Carousel createCarousel(@Nonnull final SnippetContext context, @Nonnull final Element element) {
        return new Carousel(context, element.tagName())
                .withSlides(element.getElementsByTag("slide").stream().map(Slide::create).collect(Collectors.toList()))
                .addAttributes(element.attributes())
                .withHtml(element.outerHtml());
    }

    Carousel(@Nonnull final SnippetContext context, @Nonnull final String name) {
        super(context, name);
    }

    public String getId() {
        return getAttribute("id", String.class, "carousel");
    }

    public boolean isWithControls() {
        return getAttribute("withControls", Boolean.class, true);
    }

    public boolean isWithIndicators() {
        return getAttribute("withIndicators", Boolean.class, true);
    }

    public boolean isCrossfade() {
        return getAttribute("crossfade", Boolean.class, false);
    }

    public List<Slide> getSlides() {
        return slides;
    }

    protected Carousel withSlides(final List<Slide> slides) {
        this.slides = slides;
        return self();
    }

    /**
     * @author Christophe Friederich
     * @version 2.4
     */
    public static class Slide extends Component<Slide> {

        private Image image;

        private Caption caption;

        static Slide create(@Nonnull final Element element) {
            final Slide slide = new Slide().addAttributes(element.attributes())
                    .withHtml(element.html())
                    .withImage(Image.create(Collector.findFirst(new Evaluator.Tag("slide-image"), element)))
                    .withCaption(Caption.create(Collector.findFirst(new Evaluator.Tag("slide-caption"), element)));
            return slide;
        }

        public Integer getInterval() {
            return getAttribute("interval", Integer.class, null);
        }

        public Image getImage() {
            return image;
        }

        public Slide withImage(final Image image) {
            this.image = image;
            return self();
        }

        public Caption getCaption() {
            return caption;
        }

        public Slide withCaption(final Caption caption) {
            this.caption = caption;
            return self();
        }

    }

    public static class Image extends Component<Image> {

        static Image create(@Nullable final Element element) {
            if (element == null) {
                return null;
            }
            final Image image = new Image().addAttributes(element.attributes()).withHtml(element.html());
            return image;
        }

        public String getSrc() {
            return getAttribute("src", String.class, null);
        }

        public String getAlt() {
            return getAttribute("alt", String.class, null);
        }

    }

    public static class Caption extends Component<Caption> {

        static Caption create(@Nullable final Element element) {
            if (element == null) {
                return null;
            }
            final Caption caption = new Caption().addAttributes(element.attributes()).withHtml(element.html());
            return caption;
        }

    }

}
